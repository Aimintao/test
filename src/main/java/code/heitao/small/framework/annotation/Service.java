package code.heitao.small.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Aimin
 * @Title: Service
 * @ProjectName lightFrame架构
 * @Description: Service类上的注解
 * @date 2018/6/21 14:49
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
}
