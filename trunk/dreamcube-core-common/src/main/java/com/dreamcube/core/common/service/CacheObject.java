package com.dreamcube.core.common.service;


/**
 *                       
 * Filename: CacheObject.java
 *
 * Description: 定义缓存对象，必须被集成。
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
public abstract class CacheObject {

    LocalCacheEnum category;

    /**
     * @param category
     */
    public CacheObject(LocalCacheEnum category) {
        super();
        this.category = category;
    }

}
