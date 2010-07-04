package com.dreamcube.squad.biz.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.cache.CacheKeyNameEnum;
import com.dreamcube.core.common.service.cache.CacheOrderByEnum;
import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.common.service.cache.CacheTool;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
import com.dreamcube.core.common.tools.CacheDump;
import com.dreamcube.core.common.util.exception.CommonExceptionEnum;
import com.dreamcube.core.dal.daointerface.DcSquadDAO;
import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.squad.biz.convert.SquadConvert;
import com.dreamcube.squad.biz.service.SquadLocalCache;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *                       
 * Filename: SquadLocalCache.java
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
public class SquadLocalCacheImpl implements SquadLocalCache {

    private CacheService  cacheService;

    private DcSquadDAO    dcSquadDAO;

    private static Logger log = LoggerFactory.getLogger(SquadLocalCacheImpl.class);

    /**
     * @param category
     * @param orderByStr
     * @param orderByType
     * @param count
     * @return
     * @see com.dreamcube.squad.biz.service.SquadLocalCache#sort(com.dreamcube.core.common.service.cache.LocalCacheEnum, java.lang.String, com.dreamcube.core.common.service.cache.CacheOrderByEnum, int)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<DCSquad> sort(LocalCacheEnum category, String orderByStr,
                              CacheOrderByEnum orderByType, int count) {

        DBObject orderBy = new BasicDBObject();
        orderBy.put(orderByStr, orderByType.code());

        List dbObjectList = cacheService.sort(category, orderBy, count);
        try {
            dbObjectList = CacheTool.parseDBObjectToDCObjectForList(dbObjectList, DCSquad.class);
        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
        }

        return dbObjectList;
    }

    /**
     * @return
     * @see com.dreamcube.core.common.service.cache.LocalCache#getAllCache()
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<?> getAllCache() {
        List cacheList = cacheService.getAllCacheObject(LocalCacheEnum.DC_SQUAD);

        attemptRefresh(cacheList, false);

        try {
            cacheList = CacheTool.parseDBObjectToDCObjectForList(cacheList, DCSquad.class);
        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
        }

        return cacheList;
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCache#dump()
     */
    @Override
    public void dump() {
        CacheDump.dump(this);
    }

    /**
     * @return
     * @see com.dreamcube.core.common.service.cache.LocalCache#getCacheName()
     */
    @Override
    public LocalCacheEnum getCacheName() {
        return LocalCacheEnum.DC_SQUAD;
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCache#init()
     */
    @Override
    public void init() {
        cacheService.clean(getCacheName());
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCache#refresh()
     */
    @Override
    public void refresh() {
        init();

        List<Serializable> squadList = SquadConvert.doToDomainListForSerializ(dcSquadDAO.load());

        cacheService.refresh(LocalCacheEnum.DC_SQUAD, CacheKeyNameEnum.SQUAD, squadList);

        dump();

    }

    /**
     * @param category
     * @param oldCache
     * @param newCache
     * @see com.dreamcube.core.common.service.cache.LocalCache#refresh(com.dreamcube.core.common.service.cache.LocalCacheEnum, java.lang.Object, java.lang.Object)
     */
    @Override
    public void refresh(LocalCacheEnum category, Serializable oldCache, Serializable newCache) {
        cacheService.update(category, CacheKeyNameEnum.SQUAD, oldCache, newCache);
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

    // DI ~~~
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public void setDcSquadDAO(DcSquadDAO dcSquadDAO) {
        this.dcSquadDAO = dcSquadDAO;
    }

}
