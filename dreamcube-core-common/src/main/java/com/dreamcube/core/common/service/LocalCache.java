package com.dreamcube.core.common.service;

/**
 *                       
 * Filename: LocalCache.java
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
public interface LocalCache {

    /**
     * 初始化本地缓存
     */
    void init();

    /**
     * 刷新本地缓存信息
     */
    void refresh();

    /**
     * 获取本地缓存的名称
     * @return
     */
    LocalCacheEnum getCacheName();

    /**
     * 打印缓存信息
     * @return
     */
    void dump();
}
