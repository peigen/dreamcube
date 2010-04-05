package com.dreamcube.squad.biz.service.impl;

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

    private DcSquadDAO dcdcSquadDAO;

    /**
     * @param squad
     * @see com.dreamcube.squad.biz.service.SquadService#addSquad(com.dreamcube.core.squad.domain.DCSquad)
     */
    @Override
    public void addSquad(DCSquad squad) {

        DcSquadDO dcSquad = SquadConvert.domainToDo(squad);
        dcdcSquadDAO.insert(dcSquad);
    }

}
