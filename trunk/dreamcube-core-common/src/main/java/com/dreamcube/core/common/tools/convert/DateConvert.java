package com.dreamcube.core.common.tools.convert;

import java.text.ParseException;

import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.tools.DateTool;

/**
 *                       
 * Filename: DateConvertTool.java
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
public class DateConvert implements Converter {

    private static Logger log = LoggerFactory.getLogger(DateConvert.class);

    /**
     * @param type
     * @param value
     * @return
     * @see org.apache.commons.beanutils.Converter#convert(java.lang.Class, java.lang.Object)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Object convert(Class type, Object value) {
        String p = (String) value;
        if (p == null || p.trim().length() == 0) {
            return null;
        }

        try {
            return DateTool.simpleFormatDate(p.trim());
        } catch (ParseException e1) {
            log.error("", e1);
            return null;
        }

    }

}
