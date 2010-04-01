/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2009 All Rights Reserved.
 */
package com.dreamcube.core.enrollment.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 总体说明。
 *
 * @author yue.lipy@alipay.com
 * @version $Id: DCUserRole.java,v 0.1 2010-3-31 下午02:56:28 peigen Exp $
 */

public enum DCUserRole {

    /** AXISER---发起者 */
    AXISER("AXISER", "发起者"),

    /** CUBER---参与者 */
    CUBER("CUBER", "参与者"),

    /** VC---投资者 */
    VC("VC", "投资者");
    private final String key;

    private final String desc;

    /**
     * @param key
     * @param desc
     */
    private DCUserRole(String key, String desc) {
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
    public List<DCUserRole> getAllRole() {
        List<DCUserRole> list = new ArrayList<DCUserRole>();
        for (DCUserRole role : values()) {
            list.add(role);
        }
        return list;
    }

}
