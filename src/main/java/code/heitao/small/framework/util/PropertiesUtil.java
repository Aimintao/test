package code.heitao.small.framework.util;

import code.heitao.small.framework.constant.ErrorEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Aimin
 * @Title: PropertiesUtil
 * @ProjectName lightFrame架构
 * @Description: 读取文件的配置信息到Properties对象中属性文件工具类
 * @date 2018/6/13 19:19
 */
@Slf4j
public class PropertiesUtil {

    public static Properties loadProps(String fileName) {
        /**
         * @Description: 加载属性文件
         * @param [fileName]
         * @return java.util.Properties
         * @author Aimin
         * @date 2018/6/13 19:28
         */
        Properties props = null;
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            AssertUtil.assertNull(inputStream, ErrorEnum.FILE_NAME_EMPTY);
            props = new Properties();
            props.load(inputStream);
        } catch (IOException e) {
            log.error("load properties file failure", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("close inputStream  failure", e);
                }
            }
        }
        return props;
    }

    public static String getString(Properties props, String key) {
        /**
         * @Description: 获取字符型属性（默认值为空字符串）
         * @param [props, key]
         * @return java.lang.String
         * @author Aimin
         * @date 2018/6/14 14:45
         */
        return getString(props,key,"");
    }
    public static String getString(Properties props, String key, String defaultValue) {
        /**
         * @Description: 获取字符型属性（key不存在可指定默认值）
         * @param [props, key, defaultValue]
         * @return java.lang.String
         * @author Aimin
         * @date 2018/6/14 14:46
         */
        if (!props.contains(key)){
            return  props.getProperty(key);
        }
        return defaultValue;
    }
    public static int getInt(Properties props, String key) {
        /**
         * @Description: 获取数值型属性（默认值为 0）
         * @param [props, key]
         * @return int
         * @author Aimin
         * @date 2018/6/14 14:48
         */
        return getInt(props, key, 0);
    }

    public static int getInt(Properties props, String key, int defaultValue) {
        /**
         * @Description:  获取数值型属性（key不存在可指定默认值）
         * @param [props, key, defaultValue]
         * @return int
         * @author Aimin
         * @date 2018/6/14 14:48
         */
        if (props.containsKey(key)) {
           return  CastTypeUtil.castInt(props.getProperty(key));
        }
        return defaultValue;
    }

    public static boolean getBoolean(Properties props, String key) {
        /**
         * @Description: 获取布尔型属性（默认值为 false）
         * @param [props, key]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 14:51
         */
        return getBoolean(props, key, false);
    }

    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        /**
         * @Description: 获取布尔型属性（key不存在可指定默认值）
         * @param [props, key, defaultValue]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 14:52
         */
        if (props.containsKey(key)) {
            return CastTypeUtil.castBoolean(props.getProperty(key));
        }
        return defaultValue;
    }

}
