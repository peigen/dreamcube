package com.dreamcube.enrollment.biz.service.impl;

import com.dreamcube.core.common.tools.MD5Tool;
import com.dreamcube.core.dal.daointerface.DcUserDAO;
import com.dreamcube.core.dal.dataobject.DcUserDO;
import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.enrollment.biz.convert.UserConvert;
import com.dreamcube.enrollment.biz.service.LogonService;

/**
 *                       
 * Filename: LogonServiceImpl.java
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
public class LogonServiceImpl implements LogonService {

    private DcUserDAO dcUserDAO;

    /**
     * @param user
     * @return
     * @see com.dreamcube.enrollment.biz.service.LogonService#logon(com.dreamcube.core.enrollment.domain.DCUser)
     */
    @Override
    public DCUser logon(DCUser user) {

        String passwd = MD5Tool.MD5Encode(user.getLogonPasswd());

        DcUserDO userDO = dcUserDAO.loadByLogonNameAndPasswd(user.getLogonName(), passwd);

        if (userDO == null) {
            return null;
        }

        return UserConvert.doToDomain(userDO);
    }

    // DI ~~~
    /**
     * @param dcUserDAO
     * The dcUserDAO to set.
     */
    public void setDcUserDAO(DcUserDAO dcUserDAO) {
        this.dcUserDAO = dcUserDAO;
    }

}
