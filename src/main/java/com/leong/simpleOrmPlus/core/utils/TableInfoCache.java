package com.leong.simpleOrmPlus.core.utils;

import com.leong.simpleOrmPlus.core.TableInfo;
import com.leong.simpleOrmPlus.core.annotation.TableId;
import lombok.experimental.UtilityClass;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leong
 */
@UtilityClass
public class TableInfoCache {

    public static ConcurrentHashMap<Class<?>, WeakReference<TableInfo>> cache = new ConcurrentHashMap<>(16);


    public synchronized void installCache(Class<?> cls, TableInfo tableInfo) {
        cache.put(cls, new WeakReference<>(tableInfo));
    }


    public synchronized TableInfo getCache(Class<?> cls) {
        WeakReference<TableInfo> tableInfo = cache.get(cls);
        if (tableInfo == null) {
            TableInfo info = TableInfo.createTableInfo(cls);
            installCache(cls, info);
            return TableInfo.createTableInfo(cls);
        }
        return tableInfo.get();
    }
}
