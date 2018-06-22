package code.heitao.small.framework.constant;

/**
 * @author Aimin
 * @Title: ConfigEnum
 * @ProjectName lightFrame架构
 * @Description: 配置信息
 * @date 2018/6/19 17:51
 */
public enum ConfigEnum {
    CONFIG_FILE ("properties","small.properties"),

    DBC_DRIVER ("driver","small.framework.jdbc.driver"),
    JDBC_URL ("url","small.framework.jdbc.url"),
    JDBC_USERNAME ("username","small.framework.jdbc.username"),
    JDBC_PASSWORD ("password","small.framework.jdbc.password"),

    APP_BASE_PACKAGE ("base_package","small.framework.app.base_package"),
    APP_JSP_PATH ("jsp_path","small.framework.app.jsp_path"),
    APP_ASSET_PATH ("asset_path","small.framework.app.asset_path"),
    APP_UPLOAD_LIMIT ("upload_limit","small.framework.app.upload_limit"),;
     private String code;
     private String value;

    ConfigEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static ConfigEnum getEnum(Integer code) {
        /**
         * @Description: 通过code获取枚举
         * @param [code]
         * @return code.heitao.small.framework.constant.ConfigEnum
         * @author Aimin
         * @date 2018/6/19 18:22
         */
        for (ConfigEnum an : ConfigEnum.values()) {
            if (an.getCode().equals(code)) {
                return an;
            }
        }
        return null;
    }

    public static ConfigEnum getEnum(String value) {
        /**
         * @Description: 通过value获取枚举
         * @param [typeName]
         * @return code.heitao.small.framework.constant.ConfigEnum
         * @author Aimin
         * @date 2018/6/19 18:23
         */
        for (ConfigEnum an : ConfigEnum.values()) {
            if (an.getValue().equals(value)) {
                return an;
            }
        }
        return null;
    }

    public static String getValue(Integer code) {
        /**
         * @Description: 根据枚举的key值获取枚举对应的名称
         * @param [code]
         * @return java.lang.String
         * @author Aimin
         * @date 2018/6/19 18:24
         */
        if (null == code) {
            return null;
        }
        ConfigEnum confirmStatusEnum = getEnum(code);
        return confirmStatusEnum.getValue();
    }

    public static String getCode(String value) {
        /**
         * @Description: 根据枚举对应的名称获取枚举key
         * @param [typeName]
         * @return java.lang.Integer
         * @author Aimin
         * @date 2018/6/19 18:25
         */
        if (null == value) {
            return null;
        }
        ConfigEnum confirmStatusEnum = getEnum(value);
        return confirmStatusEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
