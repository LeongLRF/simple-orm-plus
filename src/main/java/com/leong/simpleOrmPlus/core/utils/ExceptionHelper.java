package com.leong.simpleOrmPlus.core.utils;

import com.leong.simpleOrmPlus.core.annotation.TableName;
import lombok.experimental.UtilityClass;

/**
 * @author Leong
 */
@UtilityClass
public class ExceptionHelper {

    public static final String ILLEGAL_CLASS = "请添加@TableName注解";

    public void illegalClass(Class<?> cls) {
        if (!cls.isAnnotationPresent(TableName.class)) throw new IllegalArgumentException(ILLEGAL_CLASS);
    }
}
