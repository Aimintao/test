package code.heitao.small.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Aimin
 * @Title: StringUtil
 * @ProjectName lightFrame架构
 * @Description: 字符串工具
 * @date 2018/6/14 15:17
 */
public class StringUtil {

    public static boolean isEmpty(final CharSequence Istr) {
        /**
         * @Description: 判断字符串是否空
         * @param [Istr]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 15:30
         */
        return Istr == null || Istr.length() == 0;
    }

    public static boolean isNotEmpty(final CharSequence Istr) {
        /**
         * @Description: 判断字符串是否非空
         * @param [Istr]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 15:30
         */
        return !StringUtil.isEmpty(Istr);
    }
    public static boolean isAnyEmpty(CharSequence... Istrs) {
        /**
         * @Description: 判断字符数组中数据任意一个为空
         * @param [Istrs]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 15:34
         */
        if (ArrayUtils.isEmpty(Istrs)) {
            return true;
        }
        for (CharSequence cs : Istrs){
            if (isEmpty(cs)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isNoneEmpty(CharSequence... Istrs) {
        /**
         * @Description:  判断字符数组中数据没有一个为空
         * @param [Istrs]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 15:35
         */
        return !isAnyEmpty(Istrs);
    }
    public static boolean isBlank(final CharSequence Istr) {
       /**
        * @Description: 判断字符是否为空或者null
        * StringUtils.isBlank(null)      = true
        * StringUtils.isBlank("")        = true
        * StringUtils.isBlank(" ")       = true
        * StringUtils.isBlank("bob")     = false
        * @param [Istr]
        * @return boolean
        * @author Aimin
        * @date 2018/6/14 15:56
        */
        int strLen;
        if (Istr == null || (strLen = Istr.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(Istr.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
    public static boolean isNotBlank(final CharSequence cs) {
        /**
         * @Description: 判断字符是否不为空或者null
         * StringUtils.isNotBlank(null)      = false
         * StringUtils.isNotBlank("")        = false
         * StringUtils.isNotBlank(" ")       = false
         * StringUtils.isNotBlank("bob")     = true
         * StringUtils.isNotBlank("  bob  ") = true
         * @param [cs]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 15:55
         */
        return !StringUtil.isBlank(cs);
    }
    public static boolean isAnyBlank(CharSequence... css) {
        /**
         * @Description: 字符数组任意一个为blank
         *  StringUtils.isAnyBlank(null)             = true
         * StringUtils.isAnyBlank(null, "foo")      = true
         * StringUtils.isAnyBlank(null, null)       = true
         * StringUtils.isAnyBlank("", "bar")        = true
         * StringUtils.isAnyBlank("bob", "")        = true
         * StringUtils.isAnyBlank("  bob  ", null)  = true
         * StringUtils.isAnyBlank(" ", "bar")       = true
         * StringUtils.isAnyBlank("foo", "bar")     = false
         * @param [css]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 15:53
         */
        if (ArrayUtils.isEmpty(css)) {
            return true;
        }
        for (CharSequence cs : css){
            if (isBlank(cs)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isNoneBlank(CharSequence... css) {
        /**
         * @Description: 字符数组没有一个为blank
         * StringUtils.isNoneBlank(null)             = false
         * StringUtils.isNoneBlank(null, "foo")      = false
         * StringUtils.isNoneBlank(null, null)       = false
         * StringUtils.isNoneBlank("", "bar")        = false
         * StringUtils.isNoneBlank("bob", "")        = false
         * StringUtils.isNoneBlank("  bob  ", null)  = false
         * StringUtils.isNoneBlank(" ", "bar")       = false
         * StringUtils.isNoneBlank("foo", "bar")     = true
         * @param [css]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 15:57
         */
        return !isAnyBlank(css);
    }
}