package com.dreamcube.squad.biz.service.impl;

import java.util.List;

import com.dreamcube.core.common.tools.StringTool;
import com.dreamcube.core.dal.daointerface.DcSquadDAO;
import com.dreamcube.core.dal.dataobject.DcSquadDO;
import com.dreamcube.core.squad.domain.DCSquad;
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

        return SquadConvert.doToDomainCollections(dcSquadList);
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
            dcSquadDAO.insert(SquadConvert.domainToDo(dcsquad));
        }

    }

    // private method

    //~~~DI
    public void setDcSquadDAO(DcSquadDAO dcSquadDAO) {
        this.dcSquadDAO = dcSquadDAO;
    }

}
