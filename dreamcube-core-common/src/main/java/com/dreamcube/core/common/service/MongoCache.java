package com.dreamcube.core.common.service;

import java.util.List;

import com.mongodb.DBObject;

/**
 *                       
 * Filename: MongoCache.java
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
public interface MongoCache {

    /**
     * drop掉整个缓存，慎用！！！
     * @return
     */
    public boolean drop();

    /**
     * 刷新
     * 
     * @param category      缓存类别
     * @param cacheList     缓存对象集
     * @return
     */
    public boolean refresh(String category, List<DBObject> cacheList);

    /**
     * 清空缓存
     * 
     * @param category      缓存类别
     * @return
     */
    public boolean clean(String category);

    /**
     * 更新某个缓存<br>
     * 此更新方法支持批量更新，小心哦。
     * 
     * @param oldCache      老缓存对象
     * @param newCache      新缓存对象
     * @return
     */
    public boolean update(DBObject oldCache, DBObject newCache);

    /**
     * 获取全部缓存中的对象
     * 
     * @param cache      缓存对象
     * @return
     */
    public List<DBObject> getAllDBObject(DBObject cache);
}
