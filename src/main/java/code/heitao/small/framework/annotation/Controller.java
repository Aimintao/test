package code.heitao.small.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Aimin
 * @Title: Controller
 * @ProjectName lightFrame架构
 * @Description: Controller类上的注解
 * @date 2018/6/21 14:38
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
