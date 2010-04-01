/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2009 All Rights Reserved.
 */
package com.dreamcube.core.enrollment.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * ����˵����
 *
 * @author yue.lipy@alipay.com
 * @version $Id: DCUserRole.java,v 0.1 2010-3-31 ����02:56:28 peigen Exp $
 */

public enum DCUserRole {

    /** AXISER---������ */
    AXISER("AXISER", "������"),

    /** CUBER---������ */
    CUBER("CUBER", "������"),

    /** VC---Ͷ���� */
    VC("VC", "Ͷ����");
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
     * ��ȡȫ����ɫ
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
