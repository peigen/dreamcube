package com.dreamcube.squad.biz.convert;

import java.util.ArrayList;
import java.util.List;

import com.dreamcube.core.dal.dataobject.DcSquadDO;
import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.core.squad.enums.DCSquadStatusEnum;

/**
 *                       
 * Filename: SquadConvert.java
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
public class SquadConvert {

    /**
     * 
     * @param squad
     * @return
     */
    public static DcSquadDO domainToDo(DCSquad squad) {
        DcSquadDO squadDO = new DcSquadDO();
        squadDO.setId(Long.valueOf(squad.getId()));
        squadDO.setAxiser(squad.getAxiser());
        squadDO.setSquadDesc(squad.getSquadDesc());
        squadDO.setSquadName(squad.getSquadName());
        squadDO.setCubers(squad.getCubers());
        squadDO.setFollowers(squad.getFollowers());
        squadDO.setGmtCreate(squad.getGmtCreate());
        squadDO.setGmtModify(squad.getGmtModify());
        squadDO.setInvestors(squad.getInvestors());
        squadDO.setStatus(squad.getStatus().getCode());

        return squadDO;
    }

    /**
     * 
     * @param squadDO
     * @return
     */
    public static DCSquad doToDomain(DcSquadDO squadDO) {
        DCSquad squad = new DCSquad();
        squad.setId(String.valueOf(squadDO.getId()));
        squad.setAxiser(squadDO.getAxiser());
        squad.setSquadDesc(squadDO.getSquadDesc());
        squad.setSquadName(squadDO.getSquadName());
        squad.setCubers(squadDO.getCubers());
        squad.setFollowers(squadDO.getFollowers());
        squad.setGmtCreate(squadDO.getGmtCreate());
        squad.setGmtModify(squadDO.getGmtModify());
        squad.setInvestors(squadDO.getInvestors());
        squad.setStatus(DCSquadStatusEnum.valueOf(squadDO.getStatus()));

        return squad;
    }

    /**
     * 集合型
     * @param doList
     * @return
     */
    public static List<DCSquad> doToDomainCollections(List<DcSquadDO> doList) {
        List<DCSquad> squadList = new ArrayList<DCSquad>();

        for (DcSquadDO dcSquad : doList) {
            squadList.add(doToDomain(dcSquad));
        }

        return squadList;
    }

}
