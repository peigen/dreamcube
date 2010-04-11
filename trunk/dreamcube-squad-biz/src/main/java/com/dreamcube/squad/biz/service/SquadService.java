package com.dreamcube.squad.biz.service;

import java.util.Date;
import java.util.List;

import com.dreamcube.core.dal.util.PageList;
import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.core.squad.enums.DCSquadStatusEnum;

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

    /**
     * 查询团队信息，根据输入的参数查询
     * @param squadName
     * @param axiser
     * @param cubers
     * @param followers
     * @param investors
     * @param status
     * @param gmtCreate
     * @param gmtModify
     * @param pageSize
     * @param pageNum
     * @return PageList
     */
    public PageList querySquad(String squadName, String axiser, String cubers, String followers,
                               String investors, DCSquadStatusEnum status, Date gmtCreate,
                               Date gmtModify, int pageSize, int pageNum);

    /**
     * 删除方法
     * @param id
     */
    public void removeSquad(String id);
}
