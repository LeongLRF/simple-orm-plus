package com.leong.simpleOrmPlus.core;

import com.leong.simpleOrmPlus.core.annotation.TableId;
import com.leong.simpleOrmPlus.core.utils.ReflectionHelper;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Leong
 */
@Data
public class TableInfo {

    String tableName;

    Class<?> cls;

    boolean autoIncrement;

    Column primaryKey;

    Map<String, Column> columns;


    public static TableInfo createTableInfo(Class<?> cls) {
        TableInfo tableInfo = new TableInfo();
        String tableName = ReflectionHelper.getTableName(cls);
        tableInfo.setTableName(tableName);
        tableInfo.setCls(cls);
        Field[] fields = cls.getFields();
        fillTableInfo(tableInfo, fields);
        return tableInfo;
    }

    public static void fillTableInfo(TableInfo tableInfo, Field[] fields) {
        Map<String, Column> columns = new LinkedHashMap<>();
        Arrays.stream(fields).forEach(field -> {
            if (field.isAnnotationPresent(TableId.class)) {
                Column column = Column.createIdColumn(field);
                tableInfo.setAutoIncrement(column.autoIncrement);
                tableInfo.setPrimaryKey(column);
                columns.put(column.getName(), column);
            }
            if (field.isAnnotationPresent(com.leong.simpleOrmPlus.core.annotation.Column.class)) {
                Column column = Column.createNormalColumn(field);
                columns.put(column.getName(), column);
            }
            tableInfo.setColumns(columns);
        });
    }
}
