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
     * 团队列表服务
     * 
     * @return
     */
    public List<DCSquad> queryAllSquad();

    /**
     * 根据id读取团队信息
     * @param id
     * @return
     */
    public DCSquad loadById(String id);

    /**
     * 团队信息修改
     * 
     * @param id
     */
    public void editSquad(DCSquad dcsquad);

}
