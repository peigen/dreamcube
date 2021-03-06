package com.dreamcube.core.common.service.cache;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.dreamcube.core.common.tools.BeanUtilEx;
import com.dreamcube.core.common.tools.ByteTool;
import com.dreamcube.core.common.tools.DateTool;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *                       
 * Filename: CacheTool.java
 *
 * Description: 
 *
 * Version: 0.1
 *
 * Author: peigen
 *
 * Email: peigen123@gmail.com
 *
 * Blog: http://peigen.info
 *
 *       
 * History:<br>
 *<li>Author: peigen</li>
 *<li>Date: 2010-4-25</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class CacheTool {

    public static final String CATEGORY = "category";
    public static final String CACHE    = "cache_object";

    /**
     * 帮助缓存创建一个基础的缓存对象。<br>
     * 为了约束一定要有category的行为。
     * 
     * @param category
     */
    public static DBObject createDBObject(String category, DBObject cache) {
        cache.put(CATEGORY, category);
        return cache;
    }

    /**
     * 创建一个空的基础缓存对象<br>
     * 为了约束一定要有category的行为。
     * @param category
     * @return
     */
    public static DBObject createDBObject(String category) {
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.put(CATEGORY, category);
        return dbObject;
    }

    /**
     * 
     * 
     * @param cacheList
     * @param category  缓存组
     * @return
     * @throws Exception 
     */
    public static List<DBObject> parseDBObjectList(String category, String keyName,
                                                   List<Serializable> cacheList) throws Exception {
        List<DBObject> dbObjectList = new ArrayList<DBObject>();

        for (Serializable obj : cacheList) {
            dbObjectList.add(parseDBObject(category, keyName, obj));
        }

        return dbObjectList;
    }

    /**
     * @param category  缓存组
     * @param keyName   缓存key
     * @param cache     普通对象
     * @return
     * @throws Exception 
     */
    public static DBObject parseDBObject(String category, String keyName, Serializable cache)
                                                                                             throws Exception {
        BasicDBObject dbObject = new BasicDBObject();

        // 1. 缓存分类
        dbObject.put(CATEGORY, category);

        Class<?> cls = cache.getClass();

        // 2. 缓存的key
        for (Field field : cls.getDeclaredFields()) {

            if (field.getName().equals(keyName))
                dbObject.put(field.getName(), BeanUtils.getProperty(cache, field.getName()));

        }

        // 3. 缓存对象

        dbObject.put(CACHE, ByteTool.getBytesFromObject(cache));

        return dbObject;
    }

    /**
     * 转换DBObject对象为系统可识别的对象
     * 
     * @param dbObject  DBObject对象
     * @param cls       要转换成哪个对象
     * @return
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws InvocationTargetException 
     * @throws ParseException 
     */
    public static Object parseDBObjectToDCObject(DBObject dbObject, Class<?> cls)
                                                                                 throws InstantiationException,
                                                                                 IllegalAccessException,
                                                                                 InvocationTargetException,
                                                                                 ParseException {

        Object object = cls.newInstance();

        for (Field field : cls.getDeclaredFields()) {

            // 根据field名组装cache对象
            if (dbObject.containsField(field.getName())) {

                if (field.getType().equals(Date.class)) {
                    String dateStr = (String) dbObject.get(field.getName());
                    Date date = DateTool.simpleFormatDate(dateStr);
                    //                    BeanUtilEx.regiest(field.getType());
                    BeanUtilEx.copyProperty(object, field.getName(), date);
                } else {
                    BeanUtilEx.copyProperty(object, field.getName(), dbObject.get(field.getName()));
                }

            }

        }

        return object;
    }

    /**
     * 转换DBObject对象为系统可识别的对象
     * 
     * @param dbObjectList  DBObject对象
     * @param cls           要转换成哪个对象
     * @return
     * @throws ParseException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static List<Object> parseDBObjectToDCObjectForList(List<DBObject> dbObjectList,
                                                              Class<?> cls)
                                                                           throws InstantiationException,
                                                                           IllegalAccessException,
                                                                           InvocationTargetException,
                                                                           ParseException {
        List<Object> list = new ArrayList<Object>();

        for (DBObject dbObject : dbObjectList) {
            list.add(parseDBObjectToDCObject(dbObject, cls));
        }
        return list;
    }

}
