package code.heitao.small.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Aimin
 * @Title: Transaction
 * @ProjectName lightFrame架构
 * @Description: Transaction作用于Service类的方法事务管理上
 * @date 2018/6/21 14:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction {
}
