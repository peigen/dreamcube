package com.dreamcube.core.common.tools;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.ContextClassLoaderLocal;

/**
 *                       
 * Filename: BeanUtilsBeanEx.java
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
 *<li>Date: 2010-6-1</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class BeanUtilsBeanEx {

    // ------------------------------------------------------ Private Class Variables

    /** 
     * Contains <code>BeanUtilsBean</code> instances indexed by context classloader.
     */
    private static final ContextClassLoaderLocal beansByClassLoader = new ContextClassLoaderLocal() {
                                                                        // Creates the default instance used when the context classloader is unavailable
                                                                        protected Object initialValue() {
                                                                            return new BeanUtilsBeanEx();
                                                                        }
                                                                    };

    /** 
     * Gets the instance which provides the functionality for {@link BeanUtils}.
     * This is a pseudo-singleton - an single instance is provided per (thread) context classloader.
     * This mechanism provides isolation for web apps deployed in the same container. 
     */
    public synchronized static BeanUtilsBeanEx getInstance() {
        return (BeanUtilsBeanEx) beansByClassLoader.get();
    }

    /** 
     * Sets the instance which provides the functionality for {@link BeanUtils}.
     * This is a pseudo-singleton - an single instance is provided per (thread) context classloader.
     * This mechanism provides isolation for web apps deployed in the same container. 
     */
    public synchronized static void setInstance(BeanUtilsBeanEx newInstance) {
        beansByClassLoader.set(newInstance);
    }

    /**
     * <p>Set the specified property value, performing type conversions as
     * required to conform to the type of the destination property.</p>
     *
     * <p>If the property is read only then the method returns 
     * without throwing an exception.</p>
     *
     * <p>If <code>null</code> is passed into a property expecting a primitive value,
     * then this will be converted as if it were a <code>null</code> string.</p>
     *
     * <p><strong>WARNING</strong> - The logic of this method is customized
     * to meet the needs of <code>populate()</code>, and is probably not what
     * you want for general property copying with type conversion.  For that
     * purpose, check out the <code>copyProperty()</code> method instead.</p>
     *
     * <p><strong>WARNING</strong> - PLEASE do not modify the behavior of this
     * method without consulting with the Struts developer community.  There
     * are some subtleties to its functionality that are not documented in the
     * Javadoc description above, yet are vital to the way that Struts utilizes
     * this method.</p>
     *
     * @param bean Bean on which setting is to be performed
     * @param name Property name (can be nested/indexed/mapped/combo)
     * @param value Value to be set
     *
     * @exception IllegalAccessException if the caller does not have
     *  access to the property accessor method
     * @exception InvocationTargetException if the property accessor method
     *  throws an exception
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     */
    public void setProperty(Object bean, String name, Object value) throws IllegalAccessException,
                                                                   InvocationTargetException,
                                                                   SecurityException,
                                                                   NoSuchFieldException {
        Field field = null;
        try {
            field = bean.getClass().getDeclaredField(name);

            field.setAccessible(true);
            field.set(bean, value);

            return;
        } catch (Exception e1) {

            field = bean.getClass().getSuperclass().getDeclaredField(name);

            field.setAccessible(true);
            field.set(bean, value);

            return;
        }
    }

    public Object getPropertyValue(Object bean, String name) throws IllegalAccessException,
                                                            InvocationTargetException,
                                                            SecurityException, NoSuchFieldException {
        Field field = null;
        try {
            field = bean.getClass().getDeclaredField(name);

            field.setAccessible(true);
            return field.get(bean);

        } catch (Exception e1) {

            field = bean.getClass().getSuperclass().getDeclaredField(name);

            field.setAccessible(true);

            return field.get(bean);
        }
    }
}
