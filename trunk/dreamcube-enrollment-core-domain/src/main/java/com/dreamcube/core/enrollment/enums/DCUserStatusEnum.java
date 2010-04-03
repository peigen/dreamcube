/**
 * 
 */
package com.dreamcube.core.enrollment.enums;

import java.util.ArrayList;
import java.util.List;

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

public enum DCUserStatusEnum {
    /** NOT_CERTIFIED---实名认证 */
    CERTIFIED("CERTIFIED", "实名认证"),

    /** NOT_CERTIFIED---未认证 */
    NOT_CERTIFIED("NOT_CERTIFIED", "未认证");

    private final String key;

    private final String desc;

    /**
     * @param key
     * @param desc
     */
    private DCUserStatusEnum(String key, String desc) {
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
    public List<DCUserStatusEnum> getAllRole() {
        List<DCUserStatusEnum> list = new ArrayList<DCUserStatusEnum>();
        for (DCUserStatusEnum role : values()) {
            list.add(role);
        }
        return list;
    }
}
