package com.dreamcube.squad.biz.service;

import com.dreamcube.core.squad.domain.DCSquad;

/**
 *                       
 * Filename: ManageSquadService.java
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
 *<li>Date: 2010-5-18</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public interface ManageSquadService {

    /**
     * 发布团队信息
     * @param info
     * @return
     */
    public boolean publishInformation(String info);

    /**
     * 发送团队邮件
     * @param content
     * @param mail
     * @return
     */
    public boolean sendSquadMail(String content, String mail);

    /**
     * 修改团队信息
     * @param squad
     */
    public void modifySquadInFormation(DCSquad squad);

    /**
     * 剔除团队成员
     * @param cuberId
     */
    public void kickCuber(String[] cuberId);

    /**
     * 邀请团队成员
     * @param cuberId
     */
    public void inviteCuber(String[] cuberId);

    /**
     * 分配管理员
     * @param cuberId
     */
    public void assignAdmin(String[] cuberId);

    /**
     * 解散
     * @param squadId
     */
    public void dismissSquad(String squadId);

    /**
     * 确认团队成员
     * @param cuberId
     */
    public void confirmCuber(String cuberId);

}
