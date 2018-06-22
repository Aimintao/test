package code.heitao.small.framework.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Aimin
 * @Title: CastTypeUtil
 * @ProjectName lightFrame架构
 * @Description: 数据类型转换
 * @date 2018/6/14 14:53
 */
@Slf4j
public class CastTypeUtil {

    public static String castString(Object obj) {
        /**
         * @Description: 转为 String 型
         * @param [obj]
         * @return java.lang.String
         * @author Aimin
         * @date 2018/6/14 15:00
         */
        return CastTypeUtil.castString(obj, "");
    }

    public static String castString(Object obj, String defaultValue) {
        /**
         * @Description: 转为 String 型（对象为空则提供默认值）
         * @param [obj, defaultValue]
         * @return java.lang.String
         * @author Aimin
         * @date 2018/6/14 15:01
         */
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double castDouble(Object obj) {
        /**
         * @Description: 转为 double 型
         * @param [obj]
         * @return double
         * @author Aimin
         * @date 2018/6/14 15:09
         */
        return CastTypeUtil.castDouble(obj, 0);
    }

    public static double castDouble(Object obj, double defaultValue) {
        /**
         * @Description: 转为 double 型（对象为空提供默认值）
         * @param [obj, defaultValue]
         * @return double
         * @author Aimin
         * @date 2018/6/14 15:09
         */
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    defaultValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                   log.error("object cast double error",e );
                }
            }
        }
        return defaultValue;
    }

    public static long castLong(Object obj) {
        /**
         * @Description: 转为 long 型
         * @param [obj]
         * @return long
         * @author Aimin
         * @date 2018/6/14 15:59
         */
        return CastTypeUtil.castLong(obj, 0);
    }

    public static long castLong(Object obj, long defaultValue) {
        /**
         * @Description: 转为 long 型（obj为null时提供默认值）
         * @param [obj, defaultValue]
         * @return long
         * @author Aimin
         * @date 2018/6/14 15:59
         */
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    defaultValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    log.error("object cast long error",e );                }
            }
        }
        return defaultValue;
    }

    public static int castInt(Object obj) {
        /**
         * @Description: 转为 int 型
         * @param [obj]
         * @return int
         * @author Aimin
         * @date 2018/6/14 16:01
         */
        return CastTypeUtil.castInt(obj, 0);
    }

    public static int castInt(Object obj, int defaultValue) {
        /**
         * @Description: 转为 int 型（obj为null的时候提供默认值）
         * @param [obj, defaultValue]
         * @return int
         * @author Aimin
         * @date 2018/6/14 16:01
         */
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    defaultValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    log.error("object cast int error",e );
                }
            }
        }
        return defaultValue;
    }

    public static boolean castBoolean(Object obj) {
        /**
         * @Description: 转为 boolean 型
         * @param [obj]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 16:03
         */
        return CastTypeUtil.castBoolean(obj, false);
    }

    public static boolean castBoolean(Object obj, boolean defaultValue) {
        /**
         * @Description: 转为 boolean 型（obj不为null时候提供默认值）
         * @param [obj, defaultValue]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 16:03
         */
        if (obj != null) {
            defaultValue = Boolean.parseBoolean(castString(obj));
        }
        return defaultValue;
    }
}
