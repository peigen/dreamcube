package com.dreamcube.core.common.service;

import java.util.List;

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
public interface CacheService {

    /**
     * 刷新
     * 
     * @param category      缓存类别
     * @param cacheList     缓存对象集
     * @return
     */
    public boolean refresh(String category, List<?> cacheList);

    /**
     * 清空缓存
     * 
     * @param category      缓存类别
     * @return
     */
    public boolean clean(String category);

    /**
     * 初始化
     * @return
     */
    public boolean init();

    /**
     * 更新某个缓存<br>
     * 此更新方法支持批量更新，小心哦。
     * 
     * @param category      缓存类别
     * @param oldCache      老缓存对象
     * @param newCache      新缓存对象
     * @return
     */
    public boolean update(String category, Object oldCache, Object newCache);

    /**
     * 
     * @param category
     * @return
     */
    public List<?> getAllCacheObject(String category);
}