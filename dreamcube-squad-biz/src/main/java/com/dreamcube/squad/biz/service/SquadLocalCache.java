package com.dreamcube.squad.biz.service;

import java.util.List;

import com.dreamcube.core.common.service.LocalCache;
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
     * 查询全部团队信息
     * 
     * @return
     */
    public List<DCSquad> queryAll();

}