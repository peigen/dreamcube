package com.dreamcube.enrollment.biz.service;

import com.dreamcube.core.enrollment.domain.DCUser;

/**
 *                       
 * Filename: LogonService.java
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
 *<li>Date: 2010-5-25</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public interface LogonService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    public DCUser logon(DCUser user);

}
