package com.dreamcube.core.common.service.impl;

import java.util.List;

import com.dreamcube.core.common.service.CacheService;
import com.dreamcube.core.common.service.MongoCache;
import com.mongodb.DBObject;

/**
 *                       
 * Filename: CacheToolImpl.java
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
public class CacheServiceImpl implements CacheService {

    // mongo
    private MongoCache mongoCache;

    /**
     * @return
     * @see com.dreamcube.core.common.service.CacheService#init()
     */
    @Override
    public boolean init() {
        return false;
    }

    /**
     * @param category
     * @return
     * @see com.dreamcube.core.common.service.CacheService#clean(java.lang.String)
     */
    @Override
    public boolean clean(String category) {
        return mongoCache.clean(category);
    }

    /**
     * @param category
     * @param cacheList
     * @return
     * @see com.dreamcube.core.common.service.CacheService#refresh(java.lang.String, java.util.List)
     */
    @Override
    public boolean refresh(String category, List<DBObject> cacheList) {
        return mongoCache.refresh(category, cacheList);
    }

    /**
     * @param oldCache
     * @param newCache
     * @return
     * @see com.dreamcube.core.common.service.CacheService#update(com.mongodb.DBObject, com.mongodb.DBObject)
     */
    @Override
    public boolean update(DBObject oldCache, DBObject newCache) {
        return mongoCache.update(oldCache, newCache);
    }

    // DI~~~
    public void setMongoCache(MongoCache mongoCache) {
        this.mongoCache = mongoCache;
    }

}
