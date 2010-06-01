package com.dreamcube.test.service;

import org.springframework.test.AbstractTransactionalSpringContextTests;

import com.dreamcube.core.common.service.cache.CacheService;
import com.dreamcube.core.dal.daointerface.DcSquadDAO;
import com.dreamcube.squad.biz.service.SquadAttentionLocalCache;

/**
 *                       
 * Filename: DreamCubeServiceTestBase.java
 *
 * Description: 服务测试基类
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
public class DreamCubeServiceTestBase extends AbstractTransactionalSpringContextTests {

    /**
     * @return
     * @see org.springframework.test.AbstractDependencyInjectionSpringContextTests#getConfigLocations()
     */
    @Override
    protected String[] getConfigLocations() {
        String[] config = new String[] { "classpath:/spring/applicationContext-test.xml" };
        return config;
    }

    // 成员变量
    public DcSquadDAO               dcSquadDAO;

    public CacheService             cacheService;

    public SquadAttentionLocalCache squadAttentionLocalCache;

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

    /**
     * @param squadAttentionLocalCache
     * The squadAttentionLocalCache to set.
     */
    public void setSquadAttentionLocalCache(SquadAttentionLocalCache squadAttentionLocalCache) {
        this.squadAttentionLocalCache = squadAttentionLocalCache;
    }

}
