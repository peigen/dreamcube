package com.dreamcube.core.common.service.cache;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.dreamcube.core.common.tools.StringTool;
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

    /**
     * 帮助缓存创建一个基础的缓存对象。<br>
     * 为了约束一定要有category的行为。
     * 
     * @param category
     */
    public static DBObject createDBObject(String category, DBObject obj) {
        obj.put(CATEGORY, category);
        return obj;
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
     * @param objList
     * @param category  缓存组
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public static List<DBObject> parseDBObjectList(List<Object> objList, String category)
                                                                                         throws IllegalArgumentException,
                                                                                         IllegalAccessException,
                                                                                         InvocationTargetException,
                                                                                         NoSuchMethodException {
        List<DBObject> dbObjectList = new ArrayList<DBObject>();

        for (Object obj : objList) {
            dbObjectList.add(parseDBObject(obj, category));
        }

        return dbObjectList;
    }

    /**
     * 转换一个普通对象成DBObject
     * 
     * @param obj       普通对象
     * @param category  缓存组
     * 
     * @return
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     */
    public static DBObject parseDBObject(Object obj, String category)
                                                                     throws IllegalArgumentException,
                                                                     IllegalAccessException,
                                                                     InvocationTargetException,
                                                                     NoSuchMethodException {
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.put(CATEGORY, category);

        Class<?> cls = obj.getClass();

        for (Field field : cls.getDeclaredFields()) {

            // FIXME 怕和mongodb的id冲突
            if (isId(field.getName()) || field.getName().equals("serialVersionUID")) {
                continue;
            }

            String object;

            try {
                // 根据field名组装mongodb对象
                object = BeanUtils.getProperty(obj, field.getName());
            } catch (IllegalArgumentException e) {
                continue;
            }

            dbObject.put(field.getName(), object);

        }

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
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     */
    public static Object parseDBObjectToDCObject(DBObject dbObject, Class<?> cls)
                                                                                 throws InstantiationException,
                                                                                 IllegalAccessException,
                                                                                 InvocationTargetException,
                                                                                 NoSuchMethodException {

        Object object = cls.newInstance();

        for (Field field : cls.getDeclaredFields()) {

            if (dbObject.containsField(field.getName())) {

                // 根据field名组装cache对象
                BeanUtils.setProperty(object, field.getName(), dbObject.get(field.getName()));
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
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public static List<Object> parseDBObjectToDCObjectForList(List<DBObject> dbObjectList,
                                                              Class<?> cls)
                                                                           throws InstantiationException,
                                                                           IllegalAccessException,
                                                                           InvocationTargetException,
                                                                           NoSuchMethodException {
        List<Object> list = new ArrayList<Object>();

        for (DBObject dbObject : dbObjectList) {
            list.add(parseDBObjectToDCObject(dbObject, cls));
        }
        return list;
    }

    // private
    private static boolean isId(String id) {
        if (StringTool.equals(id, "id")) {
            return true;

        } else {
            return false;
        }
    }
}
