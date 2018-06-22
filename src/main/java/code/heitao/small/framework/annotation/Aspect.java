package code.heitao.small.framework.annotation;

import java.lang.annotation.*;

/**
 * @author Aimin
 * @Title: Aspect
 * @ProjectName lightFrame架构
 * @Description: 切面
 * @date 2018/6/22 16:46
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
