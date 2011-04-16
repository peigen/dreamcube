package com.dreamcube.core.common.tools;

import org.slf4j.Logger;

/**
 *                       
 * Filename: PrintLogTool.java
 *
 * Description: 打日志专用工具
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
 *<li>Date: 2010-9-14</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class PrintLogTool {

    /**
     * info日志
     * @param logStr
     * @param logger
     */
    public static void info(String logStr, Logger logger) {
        if (logger.isInfoEnabled()) {
            logger.info(logStr);
        }
    }

    /**
     * debug日志
     * @param logStr
     * @param logger
     */
    public static void debug(String logStr, Logger logger) {
        if (logger.isDebugEnabled()) {
            logger.debug(logStr);
        }
    }

}
