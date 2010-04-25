package com.dreamcube.squad.biz.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.dreamcube.core.common.tools.StringTool;
import com.dreamcube.core.dal.daointerface.DcSquadDAO;
import com.dreamcube.core.dal.dataobject.DcSquadDO;
import com.dreamcube.core.dal.util.PageList;
import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.core.squad.enums.DCSquadStatusEnum;
import com.dreamcube.squad.biz.convert.SquadConvert;
import com.dreamcube.squad.biz.service.SquadLocalCache;
import com.dreamcube.squad.biz.service.SquadService;

/**
 *                       
 * Filename: SquadServiceImpl.java
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
 *<li>Date: 2010-4-5</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class SquadServiceImpl implements SquadService {

    private static Logger   log = LoggerFactory.getLogger(SquadServiceImpl.class);

    private DcSquadDAO      dcSquadDAO;

    private SquadLocalCache squadLocalCache;

    /**
     * @return
     * @see com.dreamcube.squad.biz.service.SquadService#queryAllSquad()
     */
    @Override
    public List<DCSquad> queryAllSquad() {

        List<DcSquadDO> dcSquadList = dcSquadDAO.load();

        return SquadConvert.doToDomainList(dcSquadList);
    }

    /**
     * @param id
     * @return
     * @see com.dreamcube.squad.biz.service.SquadService#loadById(java.lang.String)
     */
    @Override
    public DCSquad loadById(String id) {
        if (StringTool.isBlank(id))
            throw new IllegalArgumentException("id不得为空");

        DcSquadDO squadDO = dcSquadDAO.loadById(Integer.valueOf(id));

        return SquadConvert.doToDomain(squadDO);
    }

    /**
     * 
     * @see com.dreamcube.squad.biz.service.SquadService#editSquad()
     */
    @Override
    public void editSquad(DCSquad dcsquad) {

        if (StringTool.isNotBlank(dcsquad.getId())) {
            dcSquadDAO.update(SquadConvert.domainToDo(dcsquad));
        } else {
            //TODO 将来权限系统起来要重构掉的，取当前操作员名称
            dcsquad.setAxiser("x");
            dcsquad.setStatus(DCSquadStatusEnum.MUSTER);
            dcSquadDAO.insert(SquadConvert.domainToDo(dcsquad));
        }
        refreshLocalCache();

    }

    /**
     * @param squadName
     * @param axiser
     * @param cubers
     * @param followers
     * @param investors
     * @param status
     * @param gmtCreate
     * @param gmtModify
     * @param pageSize
     * @param pageNum
     * @return
     * @see com.dreamcube.squad.biz.service.SquadService#querySquad(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.dreamcube.core.squad.enums.DCSquadStatusEnum, java.util.Date, java.util.Date, int, int)
     */
    public PageList querySquad(String squadName, String axiser, String cubers, String followers,
                               String investors, DCSquadStatusEnum status, Date gmtCreate,
                               Date gmtModify, int pageSize, int pageNum) {

        return dcSquadDAO.query(squadName, axiser, cubers, followers, investors,
            (status == null) ? null : status.code(), gmtCreate, gmtModify, pageSize, pageNum);

    }

    /**
     * @param id
     * @see com.dreamcube.squad.biz.service.SquadService#removeSquad(java.lang.String)
     */
    @Override
    public void removeSquad(String id) {

        if (StringTool.isBlank(id))
            throw new IllegalArgumentException("id不得为空");

        try {
            dcSquadDAO.deleteById(Long.valueOf(id));
            refreshLocalCache();
        } catch (DataAccessException e) {
            throw e;
        } catch (NumberFormatException e) {
            log.error("", e);
            throw e;
        }
    }

    // private method

    /**
     * 刷缓存
     */
    private void refreshLocalCache() {
        squadLocalCache.refresh();
    }

    //~~~DI
    public void setDcSquadDAO(DcSquadDAO dcSquadDAO) {
        this.dcSquadDAO = dcSquadDAO;
    }

    public void setSquadLocalCache(SquadLocalCache squadLocalCache) {
        this.squadLocalCache = squadLocalCache;
    }

}
