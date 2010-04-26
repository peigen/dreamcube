/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2009 All Rights Reserved.
 */
package com.dreamcube.core.enrollment.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 *Filename:DCUserRoleEnum.java<br>
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

public enum DCUserRoleEnum {

    /** AXISER---发起者 */
    AXISER("AXISER", "发起者"),

    /** CUBER---参与者 */
    CUBER("CUBER", "参与者"),

    /** VC---投资者 */
    VC("VC", "投资者"),

    /** MANAGE---管理员 */
    MANAGE("MANAGE", "管理员");

    private final String code;

    private final String message;

    /**
     * @param code
     * @param message
     */
    private DCUserRoleEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return Returns the code
     */
    public String code() {
        return code;
    }

    /**
     * @return Returns the message
     */
    public String message() {
        return message;
    }

    /**
     * 获取全部角色
     * 
     * @return
     */
    public List<DCUserRoleEnum> getAllRole() {
        List<DCUserRoleEnum> list = new ArrayList<DCUserRoleEnum>();
        for (DCUserRoleEnum role : values()) {
            list.add(role);
        }
        return list;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     * @param code
     * @return
     */
    public static DCUserRoleEnum getByCode(String code) {
        for (DCUserRoleEnum userRoleCode : values()) {
            if (userRoleCode.getCode().equals(code)) {
                return userRoleCode;
            }
        }
        return null;
    }

}
