package com.dreamcube.enrollment.biz.convert;

import java.util.ArrayList;
import java.util.List;

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
     * @param user
     * @return
     */
    public static DcUserDO domainToDo(DCUser user) {
        DcUserDO userDO = new DcUserDO();

        if (StringTool.isNotBlank(user.getId()))
            userDO.setId(Long.valueOf(user.getId()));

        userDO.setBirthday(user.getBirthday());
        userDO.setCertNo(user.getCertNo());
        userDO.setGender(user.getGender());
        userDO.setGmtCreate(user.getGmtCreate());
        userDO.setGmtModify(user.getGmtModify());
        userDO.setInfoSite(user.getInfoSite());
        userDO.setLogonName(user.getLogonName());
        userDO.setLogonPasswd(user.getLogonPasswd());
        userDO.setNickName(user.getNickName());
        userDO.setProjects(user.getProjects());
        userDO.setStatus(user.getStatus().getCode());
        userDO.setWorkSite(user.getWorkSite());

        return userDO;
    }

    /**
     * @param userDO
     * @return
     */
    public static DCUser doToDomain(DcUserDO userDO) {
        DCUser user = new DCUser();

        if (userDO.getId() > 0)
            user.setId(String.valueOf(userDO.getId()));

        user.setBirthday(userDO.getBirthday());
        user.setCertNo(userDO.getCertNo());
        user.setGender(userDO.getGender());
        user.setGmtCreate(userDO.getGmtCreate());
        user.setGmtModify(userDO.getGmtModify());
        user.setInfoSite(userDO.getInfoSite());
        user.setLogonName(userDO.getLogonName());
        user.setLogonPasswd(userDO.getLogonPasswd());
        user.setNickName(userDO.getNickName());
        user.setProjects(userDO.getProjects());
        user.setStatus(DCUserStatusEnum.getByCode(userDO.getStatus()));
        user.setWorkSite(userDO.getWorkSite());

        return user;
    }

    /**
     * @param doList
     * @return
     */
    public static List<DCUser> doToDomainList(List<DcUserDO> doList) {
        List<DCUser> domainlist = new ArrayList<DCUser>();

        for (DcUserDO userDO : doList) {
            domainlist.add(doToDomain(userDO));
        }

        return domainlist;
    }

    /**
     * @param domainList
     * @return
     */
    public List<DcUserDO> domainToDoList(List<DCUser> domainList) {
        List<DcUserDO> doList = new ArrayList<DcUserDO>();

        for (DCUser user : domainList) {
            doList.add(domainToDo(user));
        }

        return doList;
    }
}
