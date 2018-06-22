package code.heitao.small.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Aimin
 * @Title: RequestMapping
 * @ProjectName lightFrame架构
 * @Description: RequestMapping 只作用在方法上的注解
 * @date 2018/6/19 17:03
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    /**
     * 请求类型与路径GET/PSOT and so on
     */
    String value();
}