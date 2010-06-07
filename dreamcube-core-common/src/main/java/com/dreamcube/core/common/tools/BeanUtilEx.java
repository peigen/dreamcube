package com.dreamcube.core.common.tools;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.dreamcube.core.common.tools.convert.DateConvert;

/**
 *                       
 * Filename: BeanUtilEx.java
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
public class BeanUtilEx extends BeanUtils {

    static {
        ConvertUtils.register(new DateConvert(), java.util.Date.class);
        ConvertUtils.register(new DateConvert(), java.sql.Date.class);
    }

    public static void copyProperties(Object dest, Object orig) {
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void regiest(Class<?> cls) {
        ConvertUtils.register(new DateConvert(), cls);
    }
}
