package code.heitao.small.framework.config;

import code.heitao.small.framework.util.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Aimin
 * @Title: DataBaseConfig
 * @ProjectName lightFrame架构
 * @Description: 读取数据库连接JDBC信息
 * @date 2018/6/14 16:21
 */
@Slf4j
public final class DataBaseConfig {

    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL;

    private static final BasicDataSource BASIC_DATA_SOURCE;

    static {
        /**
         * @Description: 加载数据库配置文件到BasicDataSource
         * @author Aimin
         * @date 2018/6/14 16:32
         */
        CONNECTION_THREAD_LOCAL = new ThreadLocal<Connection>();

        Properties conf = PropertiesUtil.loadProps("config.properties");
        String driver = conf.getProperty("jdbc.driver");
        String url = conf.getProperty("jdbc.url");
        String username = conf.getProperty("jdbc.username");
        String password = conf.getProperty("jdbc.password");

        BASIC_DATA_SOURCE = new BasicDataSource();
        BASIC_DATA_SOURCE.setDriverClassName(driver);
        BASIC_DATA_SOURCE.setUrl(url);
        BASIC_DATA_SOURCE.setUsername(username);
        BASIC_DATA_SOURCE.setPassword(password);
    }

    public static Connection getConnection() {
        /**
         * @Description: 获取数据库连接
         * @param []
         * @return java.sql.Connection
         * @author Aimin
         * @date 2018/6/14 16:34
         */
        Connection conn = CONNECTION_THREAD_LOCAL.get();
        if (conn == null) {
            try {
                conn = BASIC_DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                log.error("get connection failure", e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_THREAD_LOCAL.set(conn);
            }
        }
        return conn;
    }

}
