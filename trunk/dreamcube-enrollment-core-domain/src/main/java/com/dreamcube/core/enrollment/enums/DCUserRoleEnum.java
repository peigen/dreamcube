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

    private final String key;

    private final String desc;

    /**
     * @param key
     * @param desc
     */
    private DCUserRoleEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    /**
     * @return Returns the key.
     */
    public String getKey() {
        return key;
    }

    /**
     * @return Returns the desc.
     */
    public String getDesc() {
        return desc;
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

}
