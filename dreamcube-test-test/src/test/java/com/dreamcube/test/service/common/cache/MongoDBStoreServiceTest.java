package com.dreamcube.test.service.common.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
import com.dreamcube.core.dal.daointerface.DcSquadDAO;
import com.dreamcube.core.dal.dataobject.DcSquadDO;
import com.dreamcube.test.service.DreamCubeServiceTestBase;

/**
 *                       
 * Filename: MongoDBStoreServiceTest.java
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
 *<li>Date: 2010-5-31</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class MongoDBStoreServiceTest extends DreamCubeServiceTestBase {

    private static Logger log = LoggerFactory.getLogger(MongoDBStoreServiceTest.class);

    @Autowired
    private DcSquadDAO    dcSquadDAO;

    @Autowired
    private CacheService  cacheService;

    public void ntestStoreCache() {
        List<DcSquadDO> squadDOList = dcSquadDAO.load();

        cacheService.clean(LocalCacheEnum.DC_SQUAD.code());
        cacheService.refresh(LocalCacheEnum.DC_SQUAD.code(), squadDOList);

    }

    public void testQueryCache() {
        List<?> cacheList = cacheService.getAllCacheObject(LocalCacheEnum.DC_SQUAD.code());
        for (Object object : cacheList) {
            log.error(object.toString());
        }
    }

    /**
     * @param dcSquadDAO
     * The dcSquadDAO to set.
     */
    public void setDcSquadDAO(DcSquadDAO dcSquadDAO) {
        this.dcSquadDAO = dcSquadDAO;
    }

    /**
     * @param cacheService
     * The cacheService to set.
     */
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

}
