package com.dreamcube.squad.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.CacheService;
import com.dreamcube.core.common.service.LocalCacheEnum;
import com.dreamcube.core.common.tools.CacheDump;
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

    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(SquadLocalCacheImpl.class);

    /**
     * @return
     * @see com.dreamcube.squad.biz.service.SquadLocalCache#queryAll()
     */
    @Override
    public List<DCSquad> queryAll() {

        List<?> list = cacheService.getAllCacheObject(LocalCacheEnum.DC_SQUAD.code());
        List<DCSquad> squadList = new ArrayList<DCSquad>();

        for (Object object : list) {
            if (object instanceof DCSquad)
                squadList.add((DCSquad) object);
        }

        return null;
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.LocalCache#dump()
     */
    @Override
    public void dump() {
        CacheDump.dump(this);
    }

    /**
     * @return
     * @see com.dreamcube.core.common.service.LocalCache#getCacheName()
     */
    @Override
    public LocalCacheEnum getCacheName() {
        return LocalCacheEnum.DC_SQUAD;
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.LocalCache#init()
     */
    @Override
    public void init() {
        cacheService.clean(getCacheName().code());
    }

    /**
     * 
     * @see com.dreamcube.core.common.service.LocalCache#refresh()
     */
    @Override
    public void refresh() {
        init();

        List<DCSquad> squadList = SquadConvert.doToDomainList(dcSquadDAO.load());

        cacheService.refresh(LocalCacheEnum.DC_SQUAD.code(), squadList);

        dump();

    }

    // private

    // DI ~~~
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public void setDcSquadDAO(DcSquadDAO dcSquadDAO) {
        this.dcSquadDAO = dcSquadDAO;
    }

}
