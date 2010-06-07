package com.dreamcube.test.service.common.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.test.service.DreamCubeServiceTestBase;

/**
 *                       
 * Filename: SquadLocalCacheServiceTest.java
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
 *<li>Date: 2010-6-2</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class SquadLocalCacheServiceTest extends DreamCubeServiceTestBase {
    private static Logger log = LoggerFactory.getLogger(SquadLocalCacheServiceTest.class);

    public void testStoreCache() {
        squadLocalCache.refresh();

    }

    @SuppressWarnings("unchecked")
    public void testQueryAll() {
        List<DCSquad> list = (List<DCSquad>) squadLocalCache.getAllCache();
        for (DCSquad dcSquad : list) {
            log.info(dcSquad.toString());
        }
    }

}
