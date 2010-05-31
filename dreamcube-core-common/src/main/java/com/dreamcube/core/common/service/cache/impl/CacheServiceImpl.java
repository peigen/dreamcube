package com.dreamcube.core.common.service.cache.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.common.service.cache.CacheTool;
import com.dreamcube.core.common.service.cache.MongoCache;
import com.dreamcube.core.common.util.exception.CommonExceptionEnum;
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

    private static Logger log = LoggerFactory.getLogger(CacheServiceImpl.class);

    // mongo
    private MongoCache    mongoCache;

    /**
     * @return
     * @see com.dreamcube.core.common.service.cache.CacheService#init()
     */
    @Override
    public boolean init() {
        return false;
    }

    /**
     * @param category
     * @return
     * @see com.dreamcube.core.common.service.cache.CacheService#clean(java.lang.String)
     */
    @Override
    public boolean clean(String category) {
        return mongoCache.clean(category);
    }

    /**
     * @param category
     * @param cacheList
     * @return
     * @see com.dreamcube.core.common.service.cache.CacheService#refresh(java.lang.String, java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean refresh(String category, List<?> cacheList) {

        List<DBObject> dbObjectList = new ArrayList<DBObject>();

        try {

            dbObjectList = (List<DBObject>) CacheTool.parseDBObjectList((List<Object>) cacheList,
                category);
        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
            return false;
        }

        return mongoCache.refresh(category, dbObjectList);
    }

    /**
     * @param oldCache
     * @param newCache
     * @return
     * @see com.dreamcube.core.common.service.cache.CacheService#update(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean update(String category, Object oldCache, Object newCache) {

        DBObject oldObject = null;
        DBObject newObject = null;

        try {
            oldObject = CacheTool.parseDBObject(oldCache, category);
            newObject = CacheTool.parseDBObject(newCache, category);
        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
        }

        return mongoCache.update(oldObject, newObject);
    }

    /**
     * @param category
     * @param orderBy
     * @param count
     * @return
     * @see com.dreamcube.core.common.service.cache.CacheService#sort(java.lang.String, com.mongodb.DBObject, int)
     */
    @Override
    public List<?> sort(String category, DBObject orderBy, int count) {
        return mongoCache.sort(category, orderBy, count);
    }

    /**
     * @param category
     * @return
     * @see com.dreamcube.core.common.service.cache.CacheService#getAllCacheObject(java.lang.String)
     */
    @Override
    public List<?> getAllCacheObject(String category) {
        DBObject cache = null;

        try {
            cache = CacheTool.createDBObject(category);
        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
        }
        return mongoCache.getAllDBObject(cache);
    }

    // DI~~~
    public void setMongoCache(MongoCache mongoCache) {
        this.mongoCache = mongoCache;
    }

}
