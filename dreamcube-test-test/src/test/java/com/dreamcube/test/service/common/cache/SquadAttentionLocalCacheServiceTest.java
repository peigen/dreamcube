package com.dreamcube.test.service.common.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.cache.entity.AttentionCache;
import com.dreamcube.test.service.DreamCubeServiceTestBase;

/**
 *                       
 * Filename: SquadAttentionLocalCacheServiceTest.java
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
 *<li>Date: 2010-6-1</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class SquadAttentionLocalCacheServiceTest extends DreamCubeServiceTestBase {

    private static Logger log = LoggerFactory.getLogger(SquadAttentionLocalCacheServiceTest.class);

    public void testStoreCache() {

        log.info("=================清空并创建缓存对象====================");

        //        squadAttentionLocalCache.refresh();

    }

    @SuppressWarnings("unchecked")
    public void ntestQueryCache() {
        List<AttentionCache> cacheList = (List<AttentionCache>) squadAttentionLocalCache
            .getAllCache();

        assertEquals(true, cacheList.size() > 0);

        log.info("=================查询缓存对象====================");
        for (Object object : cacheList) {
            log.info(object.toString());
        }

    }
}
