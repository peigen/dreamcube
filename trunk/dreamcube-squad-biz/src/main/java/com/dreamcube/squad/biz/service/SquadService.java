package com.dreamcube.squad.biz.service;

import java.util.List;

import com.dreamcube.core.squad.domain.DCSquad;

/**
 *                       
 * Filename: SquadService.java
 *
 * Description: 团队相关服务
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
public interface SquadService {

    /**
     * 新增团队
     * @param squad
     */
    public void addSquad(DCSquad squad);

    /**
     * 团队列表服务
     * 
     * @return
     */
    public List<DCSquad> queryAllSquad();

}
