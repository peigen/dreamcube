package com.dreamcube.enrollment.biz.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dreamcube.core.common.service.cache.CacheKeyNameEnum;
import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
import com.dreamcube.core.common.tools.CacheDump;
import com.dreamcube.core.dal.daointerface.DcUserDAO;
import com.dreamcube.enrollment.biz.convert.UserConvert;
import com.dreamcube.enrollment.biz.service.UserLocalCache;

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

    private CacheService cacheService;

    private DcUserDAO    dcUserDAO;

    //    private static Logger       log      = LoggerFactory.getLogger(UserLocalCacheImpl.class);

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
     * @see com.dreamcube.core.common.service.cache.LocalCache#getAllCache()
     */
    @Override
    public List<?> getAllCache() {
        // TODO
        return null;
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
        cacheService.clean(getCacheName());
    }

    /**
     * @param category
     * @param oldCache
     * @param newCache
     */
    @Override
    public void refresh(LocalCacheEnum category, Serializable oldCache, Serializable newCache) {
        if (oldCache == null || newCache == null || category == null)
            throw new IllegalArgumentException("缓存内容不得为空");

        cacheService.update(category, CacheKeyNameEnum.USER, oldCache, newCache);
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCache#refresh()
     */
    @Override
    public void refresh() {

        List<Serializable> userList = UserConvert.doToDomainListForSerializ(dcUserDAO.load());

        cacheService.refresh(LocalCacheEnum.DC_USER, CacheKeyNameEnum.USER, userList);
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
