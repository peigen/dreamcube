package com.dreamcube.enrollment.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.CacheService;
import com.dreamcube.core.common.service.CacheTool;
import com.dreamcube.core.common.service.LocalCacheEnum;
import com.dreamcube.core.common.tools.CacheDump;
import com.dreamcube.core.common.util.exception.CommonExceptionEnum;
import com.dreamcube.core.dal.daointerface.DcUserDAO;
import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.enrollment.biz.convert.UserConvert;
import com.dreamcube.enrollment.biz.service.UserLocalCache;
import com.mongodb.DBObject;

/**
 *                       
 * Filename: UserLocalCacheImpl.java
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
 *<li>Date: 2010-4-26</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class UserLocalCacheImpl implements UserLocalCache {

    private CacheService  cacheService;

    private DcUserDAO     dcUserDAO;

    private static Logger log = LoggerFactory.getLogger(UserLocalCacheImpl.class);

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
        return LocalCacheEnum.DC_USER;
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

        List<DCUser> userList = UserConvert.doToDomainList(dcUserDAO.load());
        List<DBObject> dbObjectList = new ArrayList<DBObject>();

        try {
            for (DCUser user : userList) {
                dbObjectList.add(CacheTool.parseDBObject(user, LocalCacheEnum.DC_USER.code()));
            }
        } catch (Exception e) {
            log.error(CommonExceptionEnum.DBOBJECT_PARSE_ERROR.message(), e);
        }

        cacheService.refresh(LocalCacheEnum.DC_USER.code(), dbObjectList);
    }

    // DI ~~~
    /**
     * @param cacheService
     * The cacheService to set.
     */
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * @param dcUserDAO
     * The dcUserDAO to set.
     */
    public void setDcUserDAO(DcUserDAO dcUserDAO) {
        this.dcUserDAO = dcUserDAO;
    }

}
