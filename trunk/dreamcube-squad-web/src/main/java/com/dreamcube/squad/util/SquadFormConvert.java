package com.dreamcube.squad.util;

import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.squad.form.SquadForm;

/**
 *                       
 * Filename: SquadFormConvert.java
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
 *<li>Date: 2010-4-6</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class SquadFormConvert {

    /**
     * 
     * @param squadForm
     * @return
     */
    public static DCSquad covert(SquadForm squadForm) {
        DCSquad squad = new DCSquad(squadForm.getSquadName(), squadForm.getSquadDesc(), squadForm
            .getAxiser(), squadForm.getInvestors(), squadForm.getStatus());

        return squad;
    }

    /**
     * 
     * @param squad
     * @return
     */
    public static SquadForm covert(DCSquad squad) {

        SquadForm squadForm = new SquadForm();
        squadForm.setAxiser(squad.getAxiser());
        squadForm.setSquadDesc(squad.getSquadDesc());
        squadForm.setSquadName(squad.getSquadName());
        squadForm.setCubers(squad.getCubers());
        squadForm.setFollowers(squad.getFollowers());
        squadForm.setGmtCreate(squad.getGmtCreate());
        squadForm.setGmtModify(squad.getGmtModify());
        squadForm.setInvestors(squad.getInvestors());
        squadForm.setStatus(squad.getStatus());

        return squadForm;

    }
}