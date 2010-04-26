package com.dreamcube.enrollment.biz.service;

import com.dreamcube.core.enrollment.domain.DCUser;

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
     * 用户信息修改
     * 
     * @param id
     */
    public void editUser(DCUser dcUser);

}
