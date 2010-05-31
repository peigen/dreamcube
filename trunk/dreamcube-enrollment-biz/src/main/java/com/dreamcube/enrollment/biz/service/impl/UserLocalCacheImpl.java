package com.dreamcube.enrollment.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.common.service.cache.CacheTool;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
import com.dreamcube.core.common.tools.CacheDump;
import com.dreamcube.core.common.util.exception.CommonExceptionEnum;
import com.dreamcube.core.dal.daointerface.DcUserDAO;
import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.enrollment.biz.convert.UserConvert;
import com.dreamcube.enrollment.biz.service.UserLocalCache;
import com.mongodb.DBObject;

/**
 *                       
 * Filename: UserLocalCacheImpl.java
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
 *<li>Date: 2010-4-26</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class UserLocalCacheImpl implements UserLocalCache {

    private CacheService  cacheService;

    private DcUserDAO     dcUserDAO;

    private static Logger log = LoggerFactory.getLogger(UserLocalCacheImpl.class);

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
        return LocalCacheEnum.DC_USER;
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
     * @param category
     * @param oldCache
     * @param newCache
     * @see com.dreamcube.core.common.service.cache.LocalCache#refresh(com.dreamcube.core.common.service.cache.LocalCacheEnum, java.lang.Object, java.lang.Object)
     */
    @Override
    public void refresh(LocalCacheEnum category, Object oldCache, Object newCache) {
        if (oldCache == null || newCache == null || category == null)
            throw new IllegalArgumentException("缓存内容不得为空");

        cacheService.update(category.code(), oldCache, newCache);
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCache#refresh()
     */
    @SuppressWarnings("unchecked")
    @Override
    public void refresh() {

        List<DCUser> userList = UserConvert.doToDomainList(dcUserDAO.load());
        List<DBObject> dbObjectList = new ArrayList<DBObject>();

        try {
            dbObjectList = (List<DBObject>) CacheTool
                .parseDBObject(userList, getCacheName().code());
        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
        }

        cacheService.refresh(LocalCacheEnum.DC_USER.code(), dbObjectList);
    }

    // DI ~~~
    /**
     * @param cacheService
     * The cacheService to set.
     */
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * @param dcUserDAO
     * The dcUserDAO to set.
     */
    public void setDcUserDAO(DcUserDAO dcUserDAO) {
        this.dcUserDAO = dcUserDAO;
    }

}
