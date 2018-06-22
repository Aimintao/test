package code.heitao.small.framework.util;


import code.heitao.small.framework.constant.ErrorEnum;
import code.heitao.small.framework.exception.BaseException;

/**
 * @author Aimin
 * @Title: AssertUtil
 * @ProjectName lightFrame架构
 * @Description:断言工具
 * @date 2018/6/13 21:11
 */
public class AssertUtil {
    public static void assertRegex(String value, String regex, ErrorEnum errorConst){
        AssertUtil.assertNull(value,ErrorEnum.PARAM_IS_NULL);
        if (!value.matches(regex)){
            throw new BaseException(errorConst);
        }
    }
    public static void assertNull(Object value,ErrorEnum errorConst){
        if (value == null){
            throw new BaseException(errorConst);
        }
    }
    public static void assertTrue(boolean flag,ErrorEnum errorConst){
        if(flag){
            throw new BaseException(errorConst);
        }
    }
}
