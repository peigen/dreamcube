package com.dreamcube.core.squad.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.dreamcube.core.squad.enums.DCSquadStatusEnum;

/**
 *                       
 *Filename: DCSquad.java
 *
 *Description: 
 *
 *Version: 0.1
 *
 *Author: peigen
 *
 *Email: peigen123@gmail.com
 *
 *Blog: http://peigen.info
 *
 *       
 *History:<br>
 *<li>Author: peigen</li>
 *<li>Date: 2010-4-3</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class DCSquad implements Serializable {

    private static final long serialVersionUID = -7724085100005390124L;

    private String            id;

    /** 团队名称 */
    private String            squadName;

    /** 团队简介 */
    private String            squadDesc;

    /** 创建时间 */
    private Date              gmtCreate;

    /** 修改时间 */
    private Date              gmtModify;

    /** 发起者 */
    private String            axiser;

    /** 成员ID-JSON格式 */
    private String            cubers;

    /** 跟随者-JSON格式 */
    private String            followers;

    /** 投资人-JSON格式 */
    private String            investors;

    /** 团队当前状态 */
    private DCSquadStatusEnum status;

    /** 被关注次数 */
    private String            attention;

    /**
     * @param squadName
     * @param squadDesc
     * @param axiser
     * @param investors
     * @param status
     * @param attention
     */
    public DCSquad(String squadName, String squadDesc, String axiser, String investors,
                   DCSquadStatusEnum status, String attention) {
        this.squadName = squadName;
        this.squadDesc = squadDesc;
        this.axiser = axiser;
        this.cubers = axiser;
        this.investors = investors;

        // 新建领域对象默认以下属性
        this.status = DCSquadStatusEnum.MUSTER;
        this.gmtCreate = new Date();
        this.gmtModify = new Date();
        this.attention = "0";

    }

    /**
     * 空对象 
     */
    public DCSquad() {
        super();
    }

    //~~~ DI

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    /**
     * @param status
     * The status to set.
     */
    public void setStatus(DCSquadStatusEnum status) {
        this.status = status;
    }

    /**
     * @return Returns the attention
     */
    public String getAttention() {
        return attention;
    }

    /**
     * @param attention
     * The attention to set.
     */
    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
