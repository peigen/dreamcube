package com.dreamcube.squad.biz.convert;

import com.dreamcube.core.dal.dataobject.DcSquadDO;
import com.dreamcube.core.squad.domain.DCSquad;

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
        DcSquadDO squadDo = new DcSquadDO();

        return squadDo;
    }

}
