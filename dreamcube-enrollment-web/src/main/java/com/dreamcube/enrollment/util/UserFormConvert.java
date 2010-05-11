package com.dreamcube.enrollment.util;

import com.dreamcube.core.common.tools.StringTool;
import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.enrollment.form.UserForm;

/**
 *                       
 * Filename: UserFormConvert.java
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
 *<li>Date: 2010-5-10</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class UserFormConvert {

    public static DCUser convert(UserForm userForm) {
        DCUser user = new DCUser();

        if (StringTool.isNotBlank(userForm.getId()))
            user.setId(userForm.getId());

        user.setBirthday(userForm.getBirthday());
        user.setCertNo(userForm.getCertNo());
        user.setGender(userForm.getGender());
        user.setGmtCreate(userForm.getGmtCreate());
        user.setGmtModify(userForm.getGmtModify());
        user.setInfoSite(userForm.getInfoSite());
        user.setLogonName(userForm.getLogonName());
        user.setLogonPasswd(userForm.getLogonPasswd());
        user.setNickName(userForm.getNickName());
        user.setProjects(userForm.getProjects());
        user.setStatus(userForm.getStatus());
        user.setWorkSite(userForm.getWorkSite());

        return user;
    }

    public static UserForm convert(DCUser user) {
        UserForm userForm = new UserForm();

        userForm.setBirthday(user.getBirthday());
        userForm.setCertNo(user.getCertNo());
        userForm.setGender(user.getGender());
        userForm.setGmtCreate(user.getGmtCreate());
        userForm.setGmtModify(user.getGmtModify());
        userForm.setId(user.getId());
        userForm.setInfoSite(user.getInfoSite());
        userForm.setLogonName(user.getLogonName());
        userForm.setLogonPasswd(user.getLogonPasswd());
        userForm.setNickName(user.getNickName());
        userForm.setProjects(user.getProjects());
        userForm.setStatus(user.getStatus());
        userForm.setWorkSite(user.getWorkSite());

        return userForm;
    }

}
