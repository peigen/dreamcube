package com.dreamcube.squad.biz.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.common.service.cache.CacheTool;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
import com.dreamcube.core.common.tools.CacheDump;
import com.dreamcube.core.common.util.exception.CommonExceptionEnum;
import com.dreamcube.core.dal.daointerface.DcSquadDAO;
import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.squad.biz.convert.SquadConvert;
import com.dreamcube.squad.biz.service.SquadLocalCache;

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
     * @return
     * @see com.dreamcube.squad.biz.service.SquadLocalCache#queryAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<DCSquad> queryAll() {

        List cacheList = cacheService.getAllCacheObject(LocalCacheEnum.DC_SQUAD.code());

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
        cacheService.clean(getCacheName().code());
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCache#refresh()
     */
    @Override
    public void refresh() {
        init();

        List<DCSquad> squadList = SquadConvert.doToDomainList(dcSquadDAO.load());

        cacheService.refresh(LocalCacheEnum.DC_SQUAD.code(), squadList);

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

    // DI ~~~
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public void setDcSquadDAO(DcSquadDAO dcSquadDAO) {
        this.dcSquadDAO = dcSquadDAO;
    }

}
