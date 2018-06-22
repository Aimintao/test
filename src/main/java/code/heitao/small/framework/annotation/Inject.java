package code.heitao.small.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Aimin
 * @Title: Inject
 * @ProjectName lightFrame架构
 * @Description: Inject依赖注入成员变量上
 * @date 2018/6/21 14:46
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
