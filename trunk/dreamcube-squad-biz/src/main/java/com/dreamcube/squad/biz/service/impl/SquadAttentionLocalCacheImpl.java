package com.dreamcube.squad.biz.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.cache.CacheOrderByEnum;
import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.common.service.cache.CacheTool;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
import com.dreamcube.core.common.service.cache.entity.AttentionCache;
import com.dreamcube.core.common.service.cache.entity.AttentionCategoryEnum;
import com.dreamcube.core.common.util.exception.CommonExceptionEnum;
import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.squad.biz.service.SquadAttentionLocalCache;
import com.dreamcube.squad.biz.service.SquadLocalCache;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *                       
 * Filename: SquadAttentionLocalCacheImpl.java
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
 *<li>Date: 2010-5-30</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class SquadAttentionLocalCacheImpl implements SquadAttentionLocalCache {

    private CacheService        cacheService;
    private static Logger       log        = LoggerFactory
                                               .getLogger(SquadAttentionLocalCacheImpl.class);

    private SquadLocalCache     squadLocalCache;

    private final static String orderByStr = "attention";

    private final static int    count      = 3;

    /**
     * @param category
     * @param orderByStr
     * @param orderByType
     * @param count
     * @return
     * @see com.dreamcube.squad.biz.service.SquadAttentionLocalCache#sort(java.lang.String, java.lang.String, com.dreamcube.core.common.service.cache.CacheOrderByEnum, int)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<AttentionCache> sort(String category, String orderByStr,
                                     CacheOrderByEnum orderByType, int count) {
        DBObject orderBy = new BasicDBObject();
        orderBy.put(orderByStr, orderByType.code());

        List dbObjectList = cacheService.sort(category, orderBy, count);
        try {
            dbObjectList = CacheTool.parseDBObjectToDCObjectForList(dbObjectList,
                AttentionCache.class);
        } catch (InstantiationException e) {
            log.error("", e);
        } catch (IllegalAccessException e) {
            log.error("", e);
        } catch (InvocationTargetException e) {
            log.error("", e);
        } catch (ParseException e) {
            log.error("", e);
        }
        return dbObjectList;
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCache#dump()
     */
    @Override
    public void dump() {
        //        CacheDump.dump(this);
    }

    /**
     * @return
     * @see com.dreamcube.core.common.service.cache.LocalCache#getAllCache()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<?> getAllCache() {
        List cacheList = cacheService.getAllCacheObject(LocalCacheEnum.SQUAD_ATTENTION.code());

        attemptRefresh(cacheList, false);

        try {
            cacheList = CacheTool.parseDBObjectToDCObjectForList(cacheList, AttentionCache.class);
        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
        }

        return cacheList;
    }

    /**
     * @return
     * @see com.dreamcube.core.common.service.cache.LocalCache#getCacheName()
     */
    @Override
    public LocalCacheEnum getCacheName() {
        return LocalCacheEnum.SQUAD_ATTENTION;
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCache#init()
     */
    @Override
    public void init() {
        cacheService.clean(getCacheName().code());
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCache#refresh()
     */
    @Override
    public void refresh() {
        init();

        List<DCSquad> squadList = squadLocalCache.sort(LocalCacheEnum.DC_SQUAD.code(), orderByStr,
            CacheOrderByEnum.DESC, count);

        // 转换成通用被关注对象
        List<AttentionCache> attCacheList = squadToAtt(squadList);
        cacheService.refresh(LocalCacheEnum.SQUAD_ATTENTION.code(), attCacheList);

        dump();
    }

    /**
     * @param category
     * @param oldCache
     * @param newCache
     * @see com.dreamcube.core.common.service.cache.LocalCache#refresh(com.dreamcube.core.common.service.cache.LocalCacheEnum, java.lang.Object, java.lang.Object)
     */
    @Override
    public void refresh(LocalCacheEnum category, Object oldCache, Object newCache) {
        cacheService.update(category.code(), oldCache, newCache);
    }

    // private
    /**
     * 简化query方法,尝试refresh
     * 
     * @param list  刷新列表
     * @param force 是否强制刷新
     */
    private void attemptRefresh(List<?> list, boolean force) {
        if (list == null || list.size() == 0 || force)
            refresh();
    }

    private List<AttentionCache> squadToAtt(List<DCSquad> squadList) {
        List<AttentionCache> attCacheList = new ArrayList<AttentionCache>();

        for (DCSquad dcSquad : squadList) {

            AttentionCache attCache = new AttentionCache(dcSquad.getId(), dcSquad.getSquadName(),
                Long.valueOf(dcSquad.getAttention()), AttentionCategoryEnum.SQUAD);

            attCacheList.add(attCache);
        }

        return attCacheList;
    }

    // DI~~~
    /**
     * @param cacheService
     * The cacheService to set.
     */
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * @param squadLocalCache
     * The squadLocalCache to set.
     */
    public void setSquadLocalCache(SquadLocalCache squadLocalCache) {
        this.squadLocalCache = squadLocalCache;
    }

}
