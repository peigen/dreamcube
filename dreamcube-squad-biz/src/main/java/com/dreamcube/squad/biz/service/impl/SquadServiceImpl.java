package com.dreamcube.squad.biz.service.impl;

import java.util.List;

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
     * @param squad
     * @see com.dreamcube.squad.biz.service.SquadService#addSquad(com.dreamcube.core.squad.domain.DCSquad)
     */
    @Override
    public void addSquad(DCSquad squad) {

        DcSquadDO dcSquad = SquadConvert.domainToDo(squad);
        //TODO 将来权限系统起来要重构掉的，取当前操作员名称
        dcSquad.setAxiser("x");
        dcSquadDAO.insert(dcSquad);
    }

    /**
     * @return
     * @see com.dreamcube.squad.biz.service.SquadService#queryAllSquad()
     */
    @Override
    public List<DCSquad> queryAllSquad() {

        List<DcSquadDO> dcSquadList = dcSquadDAO.load();

        return SquadConvert.doToDomainCollections(dcSquadList);
    }

    // private method

    //~~~DI
    public void setDcSquadDAO(DcSquadDAO dcSquadDAO) {
        this.dcSquadDAO = dcSquadDAO;
    }

}
