package com.leong.simpleOrmPlus.core.annotation;

import com.leong.simpleOrmPlus.core.support.BaseTypeHandler;
import com.leong.simpleOrmPlus.core.support.JdbcType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Leong
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    String value() default "";

    Class<? extends BaseTypeHandler> typeHandler() default BaseTypeHandler.class;

    JdbcType jdbcType() default JdbcType.UNDEFINE;

}
