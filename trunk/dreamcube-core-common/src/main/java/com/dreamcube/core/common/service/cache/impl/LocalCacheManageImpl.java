package com.dreamcube.core.common.service.cache.impl;

import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
import com.dreamcube.core.common.service.cache.LocalCacheManage;

/**
 *                       
 * Filename: LocalCacheManageImpl.java
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
public class LocalCacheManageImpl implements LocalCacheManage {

    private CacheService cacheService;

    /**
     * 
     * @see com.dreamcube.core.common.service.cache.LocalCacheManage#init()
     */
    @Override
    public void init() {
        cacheService.init();
    }

    /**
     * @param localCache
     * @see com.dreamcube.core.common.service.cache.LocalCacheManage#refresh(com.dreamcube.core.common.service.cache.LocalCacheEnum)
     */
    @Override
    public void refresh(LocalCacheEnum localCache) {
        //        cacheService.refresh(category, cacheList)
    }

    // private

    // DI ~~~
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

}
