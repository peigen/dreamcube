/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2009 All Rights Reserved.
 */
package com.dreamcube.core.enrollment.domain;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.Assert;

import com.dreamcube.core.enrollment.enums.DCUserStatusEnum;

/**
 *                       
 *Filename:DCUserStatus.java<br>
 *
 *Description:<br>
 *
 *Version:0.1<br>
 *
 *Author: peigen<br>
 *
 *Email: peigen123@gmail.com<br>
 *
 *Blog: http://peigen.info<br>
 *
 *       
 *History:<br>
 *<li>Author: peigen</li>
 *<li>Date: 2010-4-2</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li> 
 */

public class DCUser {

    private String           id;

    /** 登录名 */
    private String           logonName;

    /** 登录密码 */
    private String           logonPasswd;

    /** 昵称 */
    private String           nickName;

    /** 生日 */
    private Date             birthday;

    /** 身份证 */
    private String           certNo;

    /** 性别:0,female;1,male 很形象 */
    private int              gender;

    /** 工作经历JSON格式 */
    private String           workSite;

    /** 参与项目JSON格式 */
    // TODO 重构为对象
    private String           projects;

    /** SNS信息:twitter/fackbook */
    private String           infoSite;

    private Date             gmtCreate;

    private Date             gmtModify;

    /** 当前状态 */
    private DCUserStatusEnum status;

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
     * @param gmtCreate
     * @param gmtModify
     * @param status
     */
    public DCUser(String logonName, String logonPasswd, String nickName, Date birthday,
                  String certNo, int gender, String workSite, String projects, String infoSite,
                  Date gmtCreate, Date gmtModify, DCUserStatusEnum status) {
        super();
        this.logonName = logonName;
        this.logonPasswd = logonPasswd;
        this.nickName = nickName;
        this.birthday = birthday;
        this.certNo = certNo;
        this.gender = gender;
        this.workSite = workSite;
        this.projects = projects;
        this.infoSite = infoSite;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
        this.status = status;
    }

    /**
     * 空对象
     */
    public DCUser() {
        super();
    }

    /**
     * 
     */
    public void check() {

        Assert.notNull(logonName);
        Assert.notNull(logonPasswd);

    }

    // ~~~DI
    /**
     * @return Returns the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     * The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Returns the logonName.
     */
    public String getLogonName() {
        return logonName;
    }

    /**
     * @param logonName
     *            The logonName to set.
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
     * @param logonPasswd
     *            The logonPasswd to set.
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
     * @param nickName
     *            The nickName to set.
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
     * @param birthday
     *            The birthday to set.
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
     * @param certNo
     *            The certNo to set.
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
     * @param gender
     *            The gender to set.
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
     * @param projects
     *            The projects to set.
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
     * @param workSite
     *            The workSite to set.
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
     * @param infoSite
     *            The infoSite to set.
     */
    public void setInfoSite(String infoSite) {
        this.infoSite = infoSite;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * @return the status
     */
    public DCUserStatusEnum getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(DCUserStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}