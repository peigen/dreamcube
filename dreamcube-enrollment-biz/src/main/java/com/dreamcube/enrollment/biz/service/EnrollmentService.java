package com.dreamcube.enrollment.biz.service;

import java.util.Date;

import com.dreamcube.core.dal.util.PageList;
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
    public DCUser loadById(String id);

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

}
