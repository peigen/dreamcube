package com.dreamcube.squad.biz.service.impl;

import java.util.Date;

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
     * @param squad
     * @see com.dreamcube.squad.biz.service.SquadService#addSquad(com.dreamcube.core.squad.domain.DCSquad)
     */
    @Override
    public void addSquad(DCSquad squad) {

        DcSquadDO dcSquad = SquadConvert.domainToDo(squad);
        dcSquad.setStatus(DCSquadStatusEnum.MUSTER.getCode());
        dcSquad.setGmtCreate(new Date());
        dcSquad.setGmtModify(new Date());
        dcSquad.setAxiser("x");
        dcSquadDAO.insert(dcSquad);
    }

	public void setDcSquadDAO(DcSquadDAO dcSquadDAO) {
		this.dcSquadDAO = dcSquadDAO;
	}

}
