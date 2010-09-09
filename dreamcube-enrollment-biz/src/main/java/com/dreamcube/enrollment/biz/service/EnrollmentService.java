package com.dreamcube.enrollment.biz.service;

import java.util.Date;
import java.util.List;

import com.dreamcube.core.common.tools.PageList;
import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.core.enrollment.enums.DCUserStatusEnum;

/**
 *                       
 * Filename: EnrollmentService.java
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
 *<li>Date: 2010-4-26</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public interface EnrollmentService {

    /**
     * 根据id读取用户信息
     * @param id
     * @return
     */
    public DCUser loadUserById(String id);

    /**
     * 用户信息修改
     * 
     * @param id
     */
    public void editUser(DCUser dcUser);

    /**
     * 根据ID删除用户
     * 
     * @param id
     */
    public void removeUser(String id);

    /**
     * 查询团队信息，根据输入的参数查询
     * 
     * @param logonName
     * @param nickName
     * @param certNo
     * @param status
     * @param gmtCreate
     * @param gmtModify
     * @param pageSize
     * @param pageNum
     * @return
     */
    public PageList queryUser(String logonName, String nickName, String certNo,
                              DCUserStatusEnum status, Date gmtCreate, Date gmtModify,
                              int pageSize, int pageNum);

    /**
     * 校验注册时的用户名是否已被注册.<br>
     * 如果已被注册则返回false.
     * 
     * @param logonName
     * @param nickName
     * @return boolean
     */
    public boolean vaildUserName(String logonName, String nickName);

    /**
     * 获取全部用户名
     * @return
     */
    public List<String> loadAllUserName();

    /**
     * 获取被关注的用户前几名用户
     * 
     * @return
     */
    public List<DCUser> loadAttention(int size);

}
