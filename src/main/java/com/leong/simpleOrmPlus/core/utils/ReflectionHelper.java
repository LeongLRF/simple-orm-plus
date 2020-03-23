package com.leong.simpleOrmPlus.core.utils;

import com.leong.simpleOrmPlus.core.annotation.TableName;
import lombok.experimental.UtilityClass;
import org.springframework.lang.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Leong
 */
@UtilityClass
public class ReflectionHelper {

    @NonNull
    Method getMethod(Class<?> cls, Field filed) {
        String filedName = filed.getName();
        filedName = filedName.replaceFirst(filedName.substring(0, 1), filedName.substring(0, 1).toUpperCase());
        try {
            return cls.getMethod(((Boolean.TYPE == filed.getType()) ? "is" : "get") + filedName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getFiledName(Field field, Annotation annotation) {
        if (field.isAnnotationPresent(annotation.getClass())) {
            return field.getName();
        }
        throw new IllegalArgumentException("unSupport Field");
    }

    public String getTableName(Class<?> cls) {
        ExceptionHelper.illegalClass(cls);
        TableName tableName = cls.getAnnotation(TableName.class);
        return tableName.value();
    }
}
