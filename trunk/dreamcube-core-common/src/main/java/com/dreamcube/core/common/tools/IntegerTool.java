package com.dreamcube.core.common.tools;

/**
 *                       
 * Filename: IntegerTool.java
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
 *<li>Date: 2010-5-10</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class IntegerTool {

    /**
     * String to Int 空字符串返回0
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        return StringTool.isNotBlank(str) ? Integer.valueOf(str) : 0;
    }
}
