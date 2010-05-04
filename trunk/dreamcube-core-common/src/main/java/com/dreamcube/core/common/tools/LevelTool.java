package com.dreamcube.core.common.tools;

/**
 *                       
 * Filename: LevelTool.java
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
 *<li>Date: 2010-5-3</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class LevelTool {

    private static final String PROD  = "prod";

    private String              level = PROD;

    /**
     * 就一个方法
     * @return
     */
    public boolean isProd() {
        if (StringTool.equals(PROD, level))
            return true;

        return false;
    }

    // DI ~~~
    /**
     * @return Returns the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level
     * The level to set.
     */
    public void setLevel(String level) {
        this.level = level;
    }

}
