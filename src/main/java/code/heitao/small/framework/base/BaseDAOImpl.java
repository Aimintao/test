package code.heitao.small.framework.base;

import code.heitao.small.framework.config.DataBaseConfig;
import code.heitao.small.framework.entity.BaseEntity;
import code.heitao.small.framework.util.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Aimin
 * @Title: BaseDAOImpl
 * @ProjectName lightFrame架构
 * @Description: 使用Dbutil封装通用DAO类
 * @date 2018/6/14 16:18
 */
@Slf4j
public abstract class BaseDAOImpl<T extends BaseEntity>  implements BaseDAO<T>{

    private static final QueryRunner QUERY_RUNNER;

    static {
        QUERY_RUNNER = new QueryRunner();
        Connection connection = DataBaseConfig.getConnection();
    }

    public List<Map<String, Object>> executeQuery(String sql, Object... params) {
        /**
         * @Description: 查询列表
         * @param [sql, params]
         * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
         * @author Aimin
         * @date 2018/6/14 16:51
         */
        List<Map<String, Object>> result;
        try {
            Connection conn = DataBaseConfig.getConnection();
            result = QUERY_RUNNER.query(conn, sql, new MapListHandler(), params);
        } catch (Exception e) {
            log.error("execute query failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public  int executeUpdate(String sql, Object... params) {
        /**
         * @Description: 执行更新语句（包括：update、insert、delete）
         * @param [sql, params]
         * @return int
         * @author Aimin
         * @date 2018/6/14 16:52
         */
        int rows = 0;
        try {
            Connection conn = DataBaseConfig.getConnection();
            rows = QUERY_RUNNER.update(conn, sql, params);
        } catch (SQLException e) {
            log.error("execute update failure", e);
            throw new RuntimeException(e);
        }
        return rows;
    }

    public  List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
        /**
         * @Description: 查询实体列表
         * @param [entityClass, sql, params]
         * @return java.util.List<T>
         * @author Aimin
         * @date 2018/6/14 16:53
         */
        List<T> entityList;
        try {
            Connection conn = DataBaseConfig.getConnection();
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            log.error("query entity list failure", e);
            throw new RuntimeException(e);
        }
        return entityList;
    }

    public  T queryEntity(Class<T> entityClass, String sql, Object... params) {
        /**
         * @Description: 查询单个实体
         * @param [entityClass, sql, params]
         * @return T
         * @author Aimin
         * @date 2018/6/14 16:55
         */
        T entity;
        try {
            Connection conn = DataBaseConfig.getConnection();
            entity = QUERY_RUNNER.query(conn, sql, new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            log.error("query entity failure", e);
            throw new RuntimeException(e);
        }
        return entity;
    }

    public  boolean insertEntity(Class<T> entityClass, Map<String, Object> fieldMap) {
        /**
         * @Description: 插入实体
         * @param [entityClass, fieldMap]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 16:56
         */
        if (CollectionUtil.isEmpty(fieldMap)) {
            log.error("can not insert entity: fieldMap is empty");
            return false;
        }

        String sql = "INSERT INTO " + getTableName(entityClass);
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for (String fieldName : fieldMap.keySet()) {
            columns.append(fieldName).append(", ");
            values.append("?, ");
        }
        columns.replace(columns.lastIndexOf(", "), columns.length(), ")");
        values.replace(values.lastIndexOf(", "), values.length(), ")");
        sql += columns + " VALUES " + values;

        Object[] params = fieldMap.values().toArray();

        return executeUpdate(sql, params) == 1;
    }

    public  boolean updateEntity(Class<T> entityClass, long id, Map<String, Object> fieldMap) {
        /**
         * @Description: 更新实体
         * @param [entityClass, id, fieldMap]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 16:59
         */
        if (CollectionUtil.isEmpty(fieldMap)) {
            log.error("can not update entity: fieldMap is empty");
            return false;
        }

        String sql = "UPDATE " + getTableName(entityClass) + " SET ";
        StringBuilder columns = new StringBuilder();
        for (String fieldName : fieldMap.keySet()) {
            columns.append(fieldName).append(" = ?, ");
        }
        sql += columns.substring(0, columns.lastIndexOf(", ")) + " WHERE id = ?";

        List<Object> paramList = new ArrayList<Object>();
        paramList.addAll(fieldMap.values());
        paramList.add(id);
        Object[] params = paramList.toArray();

        return executeUpdate(sql, params) == 1;
    }


    public  boolean deleteEntity(Class<T> entityClass, long id) {
        /**
         * @Description: 删除实体
         * @param [entityClass, id]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 16:59
         */
        String sql = "DELETE FROM " + getTableName(entityClass) + " WHERE id = ?";
        return executeUpdate(sql, id) == 1;
    }

    public void executeSqlFile(String filePath) throws IOException {
        /**
         * @Description: 执行 指定路径下的SQL 文件
         * @param [filePath]
         * @return void
         * @author Aimin
         * @date 2018/6/14 17:02
         */
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            String sql;
            while ((sql = reader.readLine()) != null) {
                executeUpdate(sql);
            }
        } catch (Exception e) {
            log.error("execute sql file failure", e);
            throw new RuntimeException(e);
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new  RuntimeException("is close fail"+e);
                }
            }
        }
    }

    private static String getTableName(Class<?> entityClass) {
        /**
         * @Description: 通过类class获取表名
         * @param [entityClass]
         * @return java.lang.String
         * @author Aimin
         * @date 2018/6/14 17:04
         */
        return entityClass.getSimpleName();
    }
}
