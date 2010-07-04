package com.dreamcube.core.common.service.cache.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.cache.CacheKeyNameEnum;
import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.common.service.cache.CacheTool;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
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

    private static Logger      log      = LoggerFactory.getLogger(CacheServiceImpl.class);

    // mongo
    private MongoCache         mongoCache;

    public static final String CATEGORY = "category";

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
    public boolean clean(LocalCacheEnum category) {
        return mongoCache.clean(category.code());
    }

    /**
     * @param category
     * @param keyName
     * @param cacheList
     * @return
     * @see com.dreamcube.core.common.service.cache.CacheService#refresh(java.lang.String, com.dreamcube.core.common.service.cache.CacheKeyNameEnum, java.util.List)
     */
    @Override
    public boolean refresh(LocalCacheEnum category, CacheKeyNameEnum keyName,
                           List<Serializable> cacheList) {

        List<DBObject> dbObjectList = new ArrayList<DBObject>();

        try {

            dbObjectList = CacheTool.parseDBObjectList(category.code(), keyName.code(), cacheList);

        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
            return false;
        }

        return mongoCache.refresh(category.code(), dbObjectList);
    }

    /**
     * @param category
     * @param keyName
     * @param oldCache
     * @param newCache
     * @return
     * @see com.dreamcube.core.common.service.cache.CacheService#update(java.lang.String, com.dreamcube.core.common.service.cache.CacheKeyNameEnum, java.io.Serializable, java.io.Serializable)
     */
    @Override
    public boolean update(LocalCacheEnum category, CacheKeyNameEnum keyName, Serializable oldCache,
                          Serializable newCache) {

        DBObject oldObject = null;
        DBObject newObject = null;

        try {
            oldObject = CacheTool.parseDBObject(category.code(), keyName.code(), oldCache);
            newObject = CacheTool.parseDBObject(category.code(), keyName.code(), newCache);
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
    public List<?> sort(LocalCacheEnum category, DBObject orderBy, int count) {
        return mongoCache.sort(category.code(), orderBy, count);
    }

    /**
     * @param category
     * @return
     * @see com.dreamcube.core.common.service.cache.CacheService#getAllCacheObject(java.lang.String)
     */
    @Override
    public List<?> getAllCacheObject(LocalCacheEnum category) {
        DBObject cache = null;

        try {
            cache = CacheTool.createDBObject(category.code());
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
