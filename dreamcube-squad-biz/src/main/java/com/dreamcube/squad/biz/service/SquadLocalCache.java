package com.dreamcube.squad.biz.service;

import java.util.List;

import com.dreamcube.core.common.service.cache.CacheOrderByEnum;
import com.dreamcube.core.common.service.cache.LocalCache;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
import com.dreamcube.core.squad.domain.DCSquad;

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
public interface SquadLocalCache extends LocalCache {

    /**
     * 缓存内容排序
     * 
     * @param category      缓存类型
     * @param orderByStr    排序变量
     * @param orderByType   排序方式
     * @param count         取多少条
     * @return
     */
    public List<DCSquad> sort(LocalCacheEnum category, String orderByStr,
                              CacheOrderByEnum orderByType, int count);

}
