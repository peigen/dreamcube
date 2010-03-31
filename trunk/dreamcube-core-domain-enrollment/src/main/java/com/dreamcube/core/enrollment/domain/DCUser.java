/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2009 All Rights Reserved.
 */
package com.dreamcube.core.enrollment.domain;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.Assert;

import com.dreamcube.core.enrollment.enums.DCUserRole;

/**
 * ����˵����
 *
 * @author yue.lipy@alipay.com
 * @version $Id: DCUser.java,v 0.1 2010-3-31 ����01:37:28 peigen Exp $
 */

public abstract class DCUser {

    private int        id;

    /** ��¼�� */
    private String     logonName;

    /** ��¼���� */
    private String     logonPasswd;

    /** �ǳ� */
    private String     nickName;

    /** ���� */
    private Date       birthday;

    /** ���֤ */
    private String     certNo;

    /** �Ա�:0,female;1,male   ������ */
    private int        gender;

    /** ��������JSON��ʽ */
    private String     workSite;

    /** ������ĿJSON��ʽ */
    //TODO �ع�Ϊ����
    private String     projects;

    /** ��Ϣ:twitter/fackbook */
    private String     infoSite;

    /** ��ɫ */
    private DCUserRole role;

    /**
     * @param logonName
     * @param logonPasswd
     * @param nickName
     * @param birthday
     * @param certNo
     * @param gender
     * @param workSite
     * @param projects
     * @param infoSite
     * @param role
     */
    private DCUser(String logonName, String logonPasswd, String nickName, Date birthday,
                   String certNo, int gender, String workSite, String projects, String infoSite,
                   DCUserRole role) {
        this.logonName = logonName;
        this.logonPasswd = logonPasswd;
        this.nickName = nickName;
        this.birthday = birthday;
        this.certNo = certNo;
        this.gender = gender;
        this.workSite = workSite;
        this.projects = projects;
        this.infoSite = infoSite;
        this.role = role;
    }

    /**
     * ������ʵ��
     */
    public void check() {

        Assert.notNull(logonName);
        Assert.notNull(logonPasswd);

    }

    // ~~~DI
    /**
     * @return Returns the id.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Returns the logonName.
     */
    public String getLogonName() {
        return logonName;
    }

    /**
     * @param logonName The logonName to set.
     */
    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    /**
     * @return Returns the logonPasswd.
     */
    public String getLogonPasswd() {
        return logonPasswd;
    }

    /**
     * @param logonPasswd The logonPasswd to set.
     */
    public void setLogonPasswd(String logonPasswd) {
        this.logonPasswd = logonPasswd;
    }

    /**
     * @return Returns the nickName.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName The nickName to set.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return Returns the birthday.
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday The birthday to set.
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return Returns the certNo.
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * @param certNo The certNo to set.
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    /**
     * @return Returns the gender.
     */
    public int getGender() {
        return gender;
    }

    /**
     * @param gender The gender to set.
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * @return Returns the projects.
     */
    public String getProjects() {
        return projects;
    }

    /**
     * @param projects The projects to set.
     */
    public void setProjects(String projects) {
        this.projects = projects;
    }

    /**
     * @return Returns the workSite.
     */
    public String getWorkSite() {
        return workSite;
    }

    /**
     * @param workSite The workSite to set.
     */
    public void setWorkSite(String workSite) {
        this.workSite = workSite;
    }

    /**
     * @return Returns the infoSite.
     */
    public String getInfoSite() {
        return infoSite;
    }

    /**
     * @param infoSite The infoSite to set.
     */
    public void setInfoSite(String infoSite) {
        this.infoSite = infoSite;
    }

    /**
     * @return Returns the role.
     */
    public DCUserRole getRole() {
        return role;
    }

    /**
     * @param role The role to set.
     */
    public void setRole(DCUserRole role) {
        this.role = role;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
