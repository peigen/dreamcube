package com.dreamcube.enrollment.form;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

import com.dreamcube.core.common.tools.StringTool;
import com.dreamcube.core.common.tools.ValidateTool;
import com.dreamcube.core.enrollment.enums.DCUserStatusEnum;

/**
 *                       
 * Filename: UserForm.java
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
public class UserForm implements Serializable {

    private static final long serialVersionUID = -2972177260550401565L;

    private String            id;

    /** 登录名 */
    @Length(min = 2, max = 32)
    @RegExp(ValidateTool.REGEX_USER_NAME)
    @NotBlank
    private String            logonName;

    /** 登录密码 */
    private String            logonPasswd;

    private String            logonPasswdValid;

    /** 昵称 */
    private String            nickName;

    /** 生日 */
    private String            birthday;

    /** 身份证 */
    private String            certNo;

    /** 性别:0,female;1,male 很形象 */
    private int               gender;

    /** 工作经历JSON格式 */
    private String            workSite;

    /** 参与项目JSON格式 */
    // TODO 重构为对象
    private String            projects;

    /** SNS信息:twitter/fackbook */
    private String            infoSite;

    private Date              gmtCreate;

    private Date              gmtModify;

    /** 当前状态 */
    private DCUserStatusEnum  status;

    private String            pageNum;

    /** 默认每页5条 必须的 */
    private String            pageSize;

    //========== getters and setters ==========

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
     * @return Returns the logonName
     */
    public String getLogonName() {
        return logonName;
    }

    /**
     * @param logonName
     * The logonName to set.
     */
    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    /**
     * @return Returns the logonPasswd
     */
    public String getLogonPasswd() {
        return logonPasswd;
    }

    /**
     * @param logonPasswd
     * The logonPasswd to set.
     */
    public void setLogonPasswd(String logonPasswd) {
        this.logonPasswd = logonPasswd;
    }

    /**
     * @return Returns the logonPasswdValid
     */
    public String getLogonPasswdValid() {
        return logonPasswdValid;
    }

    /**
     * @param logonPasswdValid
     * The logonPasswdValid to set.
     */
    public void setLogonPasswdValid(String logonPasswdValid) {
        this.logonPasswdValid = logonPasswdValid;
    }

    /**
     * @return Returns the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     * The nickName to set.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return Returns the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     * The birthday to set.
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return Returns the certNo
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * @param certNo
     * The certNo to set.
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    /**
     * @return Returns the gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * @param gender
     * The gender to set.
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * @return Returns the workSite
     */
    public String getWorkSite() {
        return workSite;
    }

    /**
     * @param workSite
     * The workSite to set.
     */
    public void setWorkSite(String workSite) {
        this.workSite = workSite;
    }

    /**
     * @return Returns the projects
     */
    public String getProjects() {
        return projects;
    }

    /**
     * @param projects
     * The projects to set.
     */
    public void setProjects(String projects) {
        this.projects = projects;
    }

    /**
     * @return Returns the infoSite
     */
    public String getInfoSite() {
        return infoSite;
    }

    /**
     * @param infoSite
     * The infoSite to set.
     */
    public void setInfoSite(String infoSite) {
        this.infoSite = infoSite;
    }

    /**
     * @return Returns the gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     * The gmtCreate to set.
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return Returns the gmtModify
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * @param gmtModify
     * The gmtModify to set.
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * @return Returns the status
     */
    public DCUserStatusEnum getStatus() {
        return status;
    }

    /**
     * @param status
     * The status to set.
     */
    public void setStatus(DCUserStatusEnum status) {
        this.status = status;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        if (StringTool.isBlank(pageSize))
            this.pageSize = "5";

        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
