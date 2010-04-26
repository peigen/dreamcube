package com.dreamcube.enrollment.biz.convert;

import com.dreamcube.core.common.tools.StringTool;
import com.dreamcube.core.dal.dataobject.DcUserDO;
import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.core.enrollment.enums.DCUserStatusEnum;

/**
 *                       
 * Filename: UserConvert.java
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
public class UserConvert {

    /**
     * @param dcUser
     * @return
     */
    public static DcUserDO domainToDo(DCUser dcUser) {
        DcUserDO dcUserDO = new DcUserDO();

        if (StringTool.isNotBlank(dcUser.getId()))
            dcUserDO.setId(Long.valueOf(dcUser.getId()));

        dcUserDO.setBirthday(dcUser.getBirthday());
        dcUserDO.setCertNo(dcUser.getCertNo());
        dcUserDO.setGender(dcUser.getGender());
        dcUserDO.setGmtCreate(dcUser.getGmtCreate());
        dcUserDO.setGmtModify(dcUser.getGmtModify());
        dcUserDO.setInfoSite(dcUser.getInfoSite());
        dcUserDO.setLogonName(dcUser.getLogonName());
        dcUserDO.setLogonPasswd(dcUser.getLogonPasswd());
        dcUserDO.setNickName(dcUser.getNickName());
        dcUserDO.setProjects(dcUser.getProjects());
        dcUserDO.setStatus(dcUser.getStatus().getCode());
        dcUserDO.setWorkSite(dcUser.getWorkSite());

        return dcUserDO;
    }

    /**
     * @param dcUserDO
     * @return
     */
    public static DCUser doToDomain(DcUserDO dcUserDO) {
        DCUser user = new DCUser();

        if (dcUserDO.getId() > 0)
            user.setId(String.valueOf(dcUserDO.getId()));

        user.setBirthday(dcUserDO.getBirthday());
        user.setCertNo(dcUserDO.getCertNo());
        user.setGender(dcUserDO.getGender());
        user.setGmtCreate(dcUserDO.getGmtCreate());
        user.setGmtModify(dcUserDO.getGmtModify());
        user.setInfoSite(dcUserDO.getInfoSite());
        user.setLogonName(dcUserDO.getLogonName());
        user.setLogonPasswd(dcUserDO.getLogonPasswd());
        user.setNickName(dcUserDO.getNickName());
        user.setProjects(dcUserDO.getProjects());
        user.setStatus(DCUserStatusEnum.getByCode(dcUserDO.getStatus()));
        user.setWorkSite(dcUserDO.getWorkSite());

        return user;
    }
}
