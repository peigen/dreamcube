/*
 * dreamcube.com Inc.
 * Copyright (c) 2010 All Rights Reserved.
 */
package com.dreamcube.core.dal.dataobject;

// auto generated imports
import java.util.Date;

/**
 * A data object class directly models database table <tt>dc_user</tt>.
 *
 * This file is generated by <tt>dreamcube-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/dc_user.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>dreamcubedalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
public class DcUserDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.
	 */
	private long id;

	/**
	 * This property corresponds to db column <tt>logon_name</tt>.
	 */
	private String logonName;

	/**
	 * This property corresponds to db column <tt>logon_passwd</tt>.
	 */
	private String logonPasswd;

	/**
	 * This property corresponds to db column <tt>nick_name</tt>.
	 */
	private String nickName;

	/**
	 * This property corresponds to db column <tt>birthday</tt>.
	 */
	private Date birthday;

	/**
	 * This property corresponds to db column <tt>cert_no</tt>.
	 */
	private String certNo;

	/**
	 * This property corresponds to db column <tt>gender</tt>.
	 */
	private int gender;

	/**
	 * This property corresponds to db column <tt>work_site</tt>.
	 */
	private String workSite;

	/**
	 * This property corresponds to db column <tt>projects</tt>.
	 */
	private String projects;

	/**
	 * This property corresponds to db column <tt>info_site</tt>.
	 */
	private String infoSite;

	/**
	 * This property corresponds to db column <tt>gmt_create</tt>.
	 */
	private Date gmtCreate;

	/**
	 * This property corresponds to db column <tt>gmt_modify</tt>.
	 */
	private Date gmtModify;

	/**
	 * This property corresponds to db column <tt>status</tt>.
	 */
	private String status;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
	public long getId() {
		return id;
	}
	
	/**
	 * Setter method for property <tt>id</tt>.
	 * 
	 * @param id value to be assigned to property id
     */
	public void setId(long id) {
		this.id = id;
	}

    /**
     * Getter method for property <tt>logonName</tt>.
     *
     * @return property value of logonName
     */
	public String getLogonName() {
		return logonName;
	}
	
	/**
	 * Setter method for property <tt>logonName</tt>.
	 * 
	 * @param logonName value to be assigned to property logonName
     */
	public void setLogonName(String logonName) {
		this.logonName = logonName;
	}

    /**
     * Getter method for property <tt>logonPasswd</tt>.
     *
     * @return property value of logonPasswd
     */
	public String getLogonPasswd() {
		return logonPasswd;
	}
	
	/**
	 * Setter method for property <tt>logonPasswd</tt>.
	 * 
	 * @param logonPasswd value to be assigned to property logonPasswd
     */
	public void setLogonPasswd(String logonPasswd) {
		this.logonPasswd = logonPasswd;
	}

    /**
     * Getter method for property <tt>nickName</tt>.
     *
     * @return property value of nickName
     */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * Setter method for property <tt>nickName</tt>.
	 * 
	 * @param nickName value to be assigned to property nickName
     */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

    /**
     * Getter method for property <tt>birthday</tt>.
     *
     * @return property value of birthday
     */
	public Date getBirthday() {
		return birthday;
	}
	
	/**
	 * Setter method for property <tt>birthday</tt>.
	 * 
	 * @param birthday value to be assigned to property birthday
     */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

    /**
     * Getter method for property <tt>certNo</tt>.
     *
     * @return property value of certNo
     */
	public String getCertNo() {
		return certNo;
	}
	
	/**
	 * Setter method for property <tt>certNo</tt>.
	 * 
	 * @param certNo value to be assigned to property certNo
     */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

    /**
     * Getter method for property <tt>gender</tt>.
     *
     * @return property value of gender
     */
	public int getGender() {
		return gender;
	}
	
	/**
	 * Setter method for property <tt>gender</tt>.
	 * 
	 * @param gender value to be assigned to property gender
     */
	public void setGender(int gender) {
		this.gender = gender;
	}

    /**
     * Getter method for property <tt>workSite</tt>.
     *
     * @return property value of workSite
     */
	public String getWorkSite() {
		return workSite;
	}
	
	/**
	 * Setter method for property <tt>workSite</tt>.
	 * 
	 * @param workSite value to be assigned to property workSite
     */
	public void setWorkSite(String workSite) {
		this.workSite = workSite;
	}

    /**
     * Getter method for property <tt>projects</tt>.
     *
     * @return property value of projects
     */
	public String getProjects() {
		return projects;
	}
	
	/**
	 * Setter method for property <tt>projects</tt>.
	 * 
	 * @param projects value to be assigned to property projects
     */
	public void setProjects(String projects) {
		this.projects = projects;
	}

    /**
     * Getter method for property <tt>infoSite</tt>.
     *
     * @return property value of infoSite
     */
	public String getInfoSite() {
		return infoSite;
	}
	
	/**
	 * Setter method for property <tt>infoSite</tt>.
	 * 
	 * @param infoSite value to be assigned to property infoSite
     */
	public void setInfoSite(String infoSite) {
		this.infoSite = infoSite;
	}

    /**
     * Getter method for property <tt>gmtCreate</tt>.
     *
     * @return property value of gmtCreate
     */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	
	/**
	 * Setter method for property <tt>gmtCreate</tt>.
	 * 
	 * @param gmtCreate value to be assigned to property gmtCreate
     */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

    /**
     * Getter method for property <tt>gmtModify</tt>.
     *
     * @return property value of gmtModify
     */
	public Date getGmtModify() {
		return gmtModify;
	}
	
	/**
	 * Setter method for property <tt>gmtModify</tt>.
	 * 
	 * @param gmtModify value to be assigned to property gmtModify
     */
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Setter method for property <tt>status</tt>.
	 * 
	 * @param status value to be assigned to property status
     */
	public void setStatus(String status) {
		this.status = status;
	}
}