package com.dreamcube.enrollment.biz.service.impl;

import com.dreamcube.core.common.tools.StringTool;
import com.dreamcube.core.dal.daointerface.DcUserDAO;
import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.core.enrollment.enums.DCUserStatusEnum;
import com.dreamcube.enrollment.biz.convert.UserConvert;
import com.dreamcube.enrollment.biz.service.EnrollmentService;

/**
 *                       
 * Filename: EnrollmentServiceImpl.java
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
public class EnrollmentServiceImpl implements EnrollmentService {

    private DcUserDAO dcUserDAO;

    /**
     * @param dcUser
     * @see com.dreamcube.enrollment.biz.service.EnrollmentService#editUser(com.dreamcube.core.enrollment.domain.DCUser)
     */
    @Override
    public void editUser(DCUser dcUser) {

        dcUserDAO.insert(UserConvert.domainToDo(dcUser));

        if (StringTool.isNotBlank(dcUser.getId())) {
            dcUserDAO.update(UserConvert.domainToDo(dcUser));
        } else {
            dcUser.setStatus(DCUserStatusEnum.UN_CERTIFIED);
            dcUserDAO.insert(UserConvert.domainToDo(dcUser));
        }

        refreshLocalCache();

    }

    // private method

    /**
     * 刷缓存
     */
    private void refreshLocalCache() {
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
