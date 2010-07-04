package com.dreamcube.core.common.service.cache;

import java.io.Serializable;
import java.util.List;

import com.mongodb.DBObject;

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
     * @param keyName       缓存的key
     * @param cacheList     缓存对象集
     * @return
     */
    public boolean refresh(LocalCacheEnum category, CacheKeyNameEnum keyName,
                           List<Serializable> cacheList);

    /**
     * 清空缓存
     * 
     * @param category      缓存类别
     * @return
     */
    public boolean clean(LocalCacheEnum category);

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
     * @param keyName       缓存的key
     * @param oldCache      老缓存对象
     * @param newCache      新缓存对象
     * @return
     */
    public boolean update(LocalCacheEnum category, CacheKeyNameEnum keyName, Serializable oldCache,
                          Serializable newCache);

    /**
     * 
     * @param category
     * @return
     */
    public List<?> getAllCacheObject(LocalCacheEnum category);

    /**
     * 缓存内容排序
     * 
     * @param category  缓存类别
     * @param orderBy   缓存排序方式.如:
     * 
     * <li>DBObject orderBy = new BasicDBObject();</li>
     * <li>orderBy.put("attention", -1);//-1为逆序(desc),1为正序(asc)</li>
     * 
     * @param count     取几个.默认0为全部.
     * @return
     */
    public List<?> sort(LocalCacheEnum category, DBObject orderBy, int count);
}
