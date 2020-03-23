package com.leong.simpleOrmPlus.core.annotation;

import com.leong.simpleOrmPlus.core.support.IdType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Leong
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableId {

    String value() default "";

    IdType idType() default IdType.UNDEFINE;

}
