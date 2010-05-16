package com.dreamcube.core.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.CacheTool;
import com.dreamcube.core.common.service.MongoCache;
import com.dreamcube.core.common.util.exception.CommonExceptionEnum;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 *                       
 * Filename: MongoCacheImpl.java
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
public class MongoCacheImpl implements MongoCache {

    private static Logger       log             = LoggerFactory.getLogger(MongoCacheImpl.class);

    // mongo 实例
    private Mongo               mongo;

    // mongo数据库名
    private final String        DATABASENAME    = "dreamcube";

    // mongo连接名
    private final String        CONLLECTIONNAME = "dreamcubeConllection";

    private static DBCollection dbCollection;

    public DBCollection getInstance() {

        if (dbCollection == null) {
            DB db = mongo.getDB(DATABASENAME);
            dbCollection = db.getCollection(CONLLECTIONNAME);
        }
        return dbCollection;
    }

    /**
     * @return
     * @see com.dreamcube.core.common.service.MongoCache#drop()
     */
    @Override
    public boolean drop() {

        boolean isDone = false;
        try {
            getInstance().drop();

            isDone = true;
        } catch (MongoException e) {
            log.error(CommonExceptionEnum.CACHE_CLEAN_ERROR.message(), e);
        }
        return isDone;
    }

    /**
     * @param category
     * @return
     * @see com.dreamcube.core.common.service.MongoCache#clean(java.lang.String)
     */
    @Override
    public boolean clean(String category) {
        boolean isDone = false;
        try {
            DBObject cleanObj = new BasicDBObject(CacheTool.CATEGORY, category);
            getInstance().remove(cleanObj);

            isDone = true;
        } catch (MongoException e) {
            log.error(CommonExceptionEnum.CACHE_CLEAN_ERROR.message(), e);
        }
        return isDone;
    }

    /**
     * @param category
     * @param cacheList
     * @return
     * @see com.dreamcube.core.common.service.MongoCache#refresh(java.lang.String, java.util.List)
     */
    @Override
    public boolean refresh(String category, List<DBObject> cacheList) {
        boolean isDone = false;

        try {
            getInstance().insert(cacheList);

            isDone = true;
        } catch (MongoException e) {
            log.error(CommonExceptionEnum.CACHE_REFRESH_ERROR.message(), e);
        }

        return isDone;
    }

    /**
     * @param oldCache
     * @param newCache
     * @return
     * @see com.dreamcube.core.common.service.MongoCache#update(com.mongodb.DBObject, com.mongodb.DBObject)
     */
    @Override
    public boolean update(DBObject oldCache, DBObject newCache) {
        boolean isDone = false;

        try {
            getInstance().update(oldCache, newCache);

            isDone = true;
        } catch (MongoException e) {
            log.error(CommonExceptionEnum.CACHE_UPDATE_ERROR.message(), e);
        }

        return isDone;
    }

    /**
     * @param cache
     * @return
     * @see com.dreamcube.core.common.service.MongoCache#getAllDBObject(com.mongodb.DBObject)
     */
    @Override
    public List<DBObject> getAllDBObject(DBObject cache) {

        List<DBObject> dbObjectList = new ArrayList<DBObject>();

        DBCursor cur = getInstance().find(cache);

        while (cur.hasNext()) {
            dbObjectList.add(cur.next());
        }
        return dbObjectList;
    }

    // DI ~~~
    public void setMongo(Mongo mongo) {
        this.mongo = mongo;
    }

}
