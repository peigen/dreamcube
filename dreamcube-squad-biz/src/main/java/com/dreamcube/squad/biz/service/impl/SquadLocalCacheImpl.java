package com.dreamcube.squad.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.CacheService;
import com.dreamcube.core.common.service.CacheTool;
import com.dreamcube.core.common.service.LocalCacheEnum;
import com.dreamcube.core.common.tools.CacheDump;
import com.dreamcube.core.common.util.enums.CommonExceptionEnum;
import com.dreamcube.core.dal.daointerface.DcSquadDAO;
import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.squad.biz.convert.SquadConvert;
import com.dreamcube.squad.biz.service.SquadLocalCache;
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
        List<DBObject> dbObjectList = new ArrayList<DBObject>();

        try {
            for (DCSquad squad : squadList) {
                dbObjectList.add(CacheTool.parseDBObject(squad, LocalCacheEnum.DC_SQUAD.code()));
            }
        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
        }

        cacheService.refresh(LocalCacheEnum.DC_SQUAD.code(), dbObjectList);

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
