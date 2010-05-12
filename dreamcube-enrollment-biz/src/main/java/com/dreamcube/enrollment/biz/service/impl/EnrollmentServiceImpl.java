package com.dreamcube.enrollment.biz.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.dreamcube.core.common.tools.StringTool;
import com.dreamcube.core.dal.daointerface.DcUserDAO;
import com.dreamcube.core.dal.dataobject.DcUserDO;
import com.dreamcube.core.dal.util.PageList;
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

    private static Logger log = LoggerFactory.getLogger(EnrollmentServiceImpl.class);

    private DcUserDAO     dcUserDAO;

    /**
     * @param dcUser
     * @see com.dreamcube.enrollment.biz.service.EnrollmentService#editUser(com.dreamcube.core.enrollment.domain.DCUser)
     */
    @Override
    public void editUser(DCUser dcUser) {

        if (StringTool.isNotBlank(dcUser.getId())) {
            dcUserDAO.update(UserConvert.domainToDo(dcUser));
        } else {
            dcUser.setStatus(DCUserStatusEnum.UN_CERTIFIED);
            dcUserDAO.insert(UserConvert.domainToDo(dcUser));
        }

        refreshLocalCache();

    }

    /**
     * @param id
     * @return
     * @see com.dreamcube.enrollment.biz.service.EnrollmentService#loadById(java.lang.String)
     */
    @Override
    public DCUser loadById(String id) {
        if (StringTool.isBlank(id))
            throw new IllegalArgumentException("id不得为空");

        DcUserDO dcUserDO = dcUserDAO.loadById(Integer.valueOf(id));

        return UserConvert.doToDomain(dcUserDO);
    }

    /**
     * @param logonName
     * @param nickName
     * @param certNo
     * @param status
     * @param gmtCreate
     * @param gmtModify
     * @param pageSize
     * @param pageNum
     * @return
     * @see com.dreamcube.enrollment.biz.service.EnrollmentService#queryUser(java.lang.String, java.lang.String, java.lang.String, com.dreamcube.core.enrollment.enums.DCUserStatusEnum, java.util.Date, java.util.Date, int, int)
     */
    @Override
    public PageList queryUser(String logonName, String nickName, String certNo,
                              DCUserStatusEnum status, Date gmtCreate, Date gmtModify,
                              int pageSize, int pageNum) {

        return dcUserDAO.query(logonName, nickName, certNo,
            (status == null) ? null : status.code(), gmtCreate, gmtModify, pageSize, pageNum);
    }

    /**
     * @param id
     * @see com.dreamcube.enrollment.biz.service.EnrollmentService#removeUser(java.lang.String)
     */
    @Override
    public void removeUser(String id) {
        if (StringTool.isBlank(id))
            throw new IllegalArgumentException("id不得为空");

        try {
            dcUserDAO.deleteById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            throw e;
        } catch (NumberFormatException e) {
            log.error("用户删除出错:", e);
            throw e;
        }
    }

    /**
     * @param logonName
     * @param nickName
     * @return boolean
     * @see com.dreamcube.enrollment.biz.service.EnrollmentService#vaildUserName(java.lang.String, java.lang.String)
     */
    @Override
    public boolean vaildUserName(String logonName, String nickName) {

        DcUserDO dcUserDO = dcUserDAO.loadByLogonNameOrNickName(logonName, nickName);

        return (dcUserDO != null) ? false : true;
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
