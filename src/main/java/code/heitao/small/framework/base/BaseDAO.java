package code.heitao.small.framework.base;


import code.heitao.small.framework.entity.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Aimin
 * @Title: BaseDAO
 * @ProjectName lightFrame架构
 * @Description: TODO
 * @date 2018/6/15 15:10
 */
public interface BaseDAO<T extends BaseEntity> {
    public List<Map<String, Object>> executeQuery(String sql, Object... params);
    public  int executeUpdate(String sql, Object... params) throws  Exception;
    public  List<T> queryEntityList(Class<T> entityClass, String sql, Object... params);
    public  T queryEntity(Class<T> entityClass, String sql, Object... params);
    public  boolean insertEntity(Class<T> entityClass, Map<String, Object> fieldMap)throws Exception ;
    public  boolean updateEntity(Class<T> entityClass, long id, Map<String, Object> fieldMap) throws  Exception;
    public  boolean deleteEntity(Class<T> entityClass, long id)throws  Exception;

}
