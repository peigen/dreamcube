package com.dreamcube.test.service.common.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.cache.LocalCacheEnum;
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

    public void testStoreCache() {
        List<DcSquadDO> squadDOList = dcSquadDAO.load();

        log.info("=================清空缓存对象====================");
        cacheService.clean(LocalCacheEnum.DC_SQUAD.code());

        log.info("=================创建缓存对象====================");
        cacheService.refresh(LocalCacheEnum.DC_SQUAD.code(), squadDOList);

    }

    public void testQueryCache() {
        log.info("=================查询缓存对象====================");
        List<?> cacheList = cacheService.getAllCacheObject(LocalCacheEnum.DC_SQUAD.code());

        assertEquals(true, cacheList.size() > 0);

        for (Object object : cacheList) {
            log.error(object.toString());
        }
    }

}
