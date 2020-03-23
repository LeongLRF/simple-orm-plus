package com.leong.simpleOrmPlus.core;

import com.leong.simpleOrmPlus.core.annotation.TableId;
import com.leong.simpleOrmPlus.core.support.IdType;
import com.leong.simpleOrmPlus.core.support.JdbcType;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author Leong
 */
@Data
public class Column {

    String name;

    JdbcType jdbcType;

    boolean primaryKey = false;

    boolean autoIncrement = false;


    public static Column createIdColumn(Field field) {
        TableId tableId = field.getAnnotation(TableId.class);
        Column column = new Column();
        column.setName(StringUtils.isEmpty(tableId.value()) ? field.getName() : tableId.value());
        column.setAutoIncrement(tableId.idType().equals(IdType.AUTO));
        column.setPrimaryKey(true);
        return column;
    }

    public static Column createNormalColumn(Field field) {
        com.leong.simpleOrmPlus.core.annotation.Column column = field.getAnnotation(com.leong.simpleOrmPlus.core.annotation.Column.class);
        Column normalColumn = new Column();
        normalColumn.setPrimaryKey(false);
        normalColumn.setName(StringUtils.isEmpty(column.value()) ? field.getName() : column.value());
        normalColumn.setJdbcType(column.jdbcType());
        return normalColumn;
    }
}
