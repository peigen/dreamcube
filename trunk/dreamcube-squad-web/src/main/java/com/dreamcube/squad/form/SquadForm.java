package com.dreamcube.squad.form;

import java.io.Serializable;
import java.util.Date;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

import com.dreamcube.core.common.tools.ValidateTool;
import com.dreamcube.core.squad.enums.DCSquadStatusEnum;

/**
 * 
 * Filename: SquadForm.java
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
 *<li>Date: 2010-4-5</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 * 
 */
public class SquadForm implements Serializable {
	private static final long serialVersionUID = -1364804142287870679L;

	/** 团队名称 */
	@Length(min = 2, max = 32)
	@RegExp(ValidateTool.REGEX_USER_NAME)
	@NotBlank
	private String squadName;

	/** 团队简介 */
	private String squadDesc;

	/** 校验码 */
	@RegExp(ValidateTool.REGUX_VALIDATE_CODE)
	private String authcodeTxt;

	private Date gmtCreate;

	private Date gmtModify;

	/** 发起者 */
	private String axiser;

	/** 成员ID-JSON格式 */
	private String cubers;

	/** 跟随者-JSON格式 */
	private String followers;

	/** 投资人-JSON格式 */
	private String investors;

	/** 团队当前状态 */
	private DCSquadStatusEnum status;

	public String getSquadName() {
		return squadName;
	}

	public void setSquadName(String squadName) {
		this.squadName = squadName;
	}

	public String getSquadDesc() {
		return squadDesc;
	}

	public void setSquadDesc(String squadDesc) {
		this.squadDesc = squadDesc;
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

	public String getAxiser() {
		return axiser;
	}

	public void setAxiser(String axiser) {
		this.axiser = axiser;
	}

	public String getCubers() {
		return cubers;
	}

	public void setCubers(String cubers) {
		this.cubers = cubers;
	}

	public String getFollowers() {
		return followers;
	}

	public void setFollowers(String followers) {
		this.followers = followers;
	}

	public String getInvestors() {
		return investors;
	}

	public void setInvestors(String investors) {
		this.investors = investors;
	}

	public DCSquadStatusEnum getStatus() {
		return status;
	}

	public void setStatus(DCSquadStatusEnum status) {
		this.status = status;
	}

	public String getAuthcodeTxt() {
		return authcodeTxt;
	}

	public void setAuthcodeTxt(String authcodeTxt) {
		this.authcodeTxt = authcodeTxt;
	}

}
