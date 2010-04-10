package com.dreamcube.squad.biz.service.impl;

import java.util.Date;
import java.util.List;

import com.dreamcube.core.common.tools.StringTool;
import com.dreamcube.core.dal.daointerface.DcSquadDAO;
import com.dreamcube.core.dal.dataobject.DcSquadDO;
import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.core.squad.enums.DCSquadStatusEnum;
import com.dreamcube.squad.biz.convert.SquadConvert;
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

    private DcSquadDAO dcSquadDAO;

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
     * @return
     * @see com.dreamcube.squad.biz.service.SquadService#querySquad(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.dreamcube.core.squad.enums.DCSquadStatusEnum, java.util.Date, java.util.Date)
     */
    @Override
    public List<DCSquad> querySquad(String squadName, String axiser, String cubers,
                                    String followers, String investors, DCSquadStatusEnum status,
                                    Date gmtCreate, Date gmtModify) {

        return SquadConvert.doToDomainList(dcSquadDAO.query(squadName, axiser, cubers, followers,
            investors, (status == null) ? null : status.code(), gmtCreate, gmtModify));

    }

    // private method
    //~~~DI
    public void setDcSquadDAO(DcSquadDAO dcSquadDAO) {
        this.dcSquadDAO = dcSquadDAO;
    }

}
