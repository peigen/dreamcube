package com.dreamcube.core.common.tools;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.enums.EnumUtils;
import org.springframework.util.ReflectionUtils;

/**
 *                       
 * Filename: JDKEnumUtils.java
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
 *<li>Date: 2010-4-7</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
@SuppressWarnings("unchecked")
public class JDKEnumUtils {

    private static final String GET_METHOD_PREFIX = "get";

    /** 定义被扫描的enum,填到包名即可 */
    static String[]             enumPackages      = { "com.dreamcube.core.squad.enums.",
            "com.dreamcube.core.common.util.enums.", "com.dreamcube.core.enrollment.enums." };

    /**
     * 获取枚举Class，支持传入参数enum全路径，用来防止多个enum同个名字。<br>
     * 
     * @param className
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Class<Enum> getJDKEnumClass(String className) {
        Class<Enum> clazz = null;
        for (String enumPackage : enumPackages) {
            try {
                if (StringTool.contains(className, ".")) {// 针对传全路径类名
                    clazz = (Class<Enum>) Class.forName(className);
                    if (clazz != null && clazz.isInstance(Enum.class)) {
                        return clazz;
                    }
                } else {// 针对类名
                    clazz = (Class<Enum>) Class.forName(enumPackage + className);
                    if (clazz != null && clazz.isInstance(Enum.class)) {
                        return clazz;
                    }
                }
            } catch (Exception e) {

            }
        }
        return clazz;
    }

    /**
     * 获取枚举中的对象列表
     * @param enumClass
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List getEnumList(Class enumClass) {
        return new ArrayList(EnumSet.allOf(enumClass));
    }

    /**
     * 获取枚举中的对象列表
     * 
     * @param enumName
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List getEnumList(String enumName) {
        return new ArrayList(EnumSet.allOf(getJDKEnumClass(enumName)));
    }

    @SuppressWarnings("rawtypes")
    public static Map getEnumMap(Class enumClass) {
        HashMap map = new HashMap();
        Iterator itr = EnumUtils.iterator(enumClass);
        while (itr.hasNext()) {
            Enum enm = (Enum) itr.next();
            map.put(enm.name(), enm);
        }
        return map;
    }

    /**
     * 获取JDK ENUM 信息
     * @param className         类名
     * @param compareProperty   比较属性名称
     * @param messageProperty   输出信息属性名称
     * @param compareValue      比较值
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String getJDKEnumMessage(String className, String compareProperty,
                                           String messageProperty, String compareValue) {
        Class<Enum> enumClass = getJDKEnumClass(className);
        if (enumClass == null || StringTool.isBlank(messageProperty)) {
            return null;
        }

        Method getCompareProperty = ReflectionUtils.findMethod(enumClass,
            propertyGetName(compareProperty), new Class[] {});

        Method getMessageProperty = ReflectionUtils.findMethod(enumClass,
            propertyGetName(messageProperty), new Class[] {});

        if (getCompareProperty == null || getMessageProperty == null) {
            return null;
        }

        // 遍历比较enum值
        try {
            Enum[] enumValues = enumClass.getEnumConstants();
            for (Enum enumValue : enumValues) {
                String comparePropertyValue = (String) getCompareProperty.invoke(enumValue,
                    new Object[] {});

                if (StringTool.equals(comparePropertyValue, compareValue)) {
                    return (String) getMessageProperty.invoke(enumValue, new Object[] {});
                }
            }
        } catch (Exception e) {
            // do nothing
        }

        return null;
    }

    public static String getEnumByCode(String className, String code) {

        return getJDKEnumMessage(className, "code", "message", code);
    }

    public static String getEnumByMessage(String className, String message) {

        return getJDKEnumMessage(className, "message", "code", message);
    }

    /**
     * 获取属性方法名
     * @param propertyName
     * @return
     */
    private static String propertyGetName(String propertyName) {
        return GET_METHOD_PREFIX + StringTool.substring(propertyName, 0, 1).toUpperCase()
               + StringTool.substring(propertyName, 1, propertyName.length());
    }

}
