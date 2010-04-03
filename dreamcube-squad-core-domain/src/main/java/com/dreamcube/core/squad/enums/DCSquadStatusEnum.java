package com.dreamcube.core.squad.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 *Filename: DCSquadStatus.java
 *
 *Description: 团队状态
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
public enum DCSquadStatusEnum {

    /** MUSTER---召集阶段 */
    MUSTER("MUSTER", "召集阶段"),

    /** DEV---开发阶段 */
    DEV("DEV", "开发阶段"),

    /** RELEASE---发布阶段 */
    RELEASE("RELEASE", "发布阶段");

    private final String key;

    private final String desc;

    /**
     * @param key
     * @param desc
     */
    private DCSquadStatusEnum(String key, String desc) {
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
    public List<DCSquadStatusEnum> getAllRole() {
        List<DCSquadStatusEnum> list = new ArrayList<DCSquadStatusEnum>();
        for (DCSquadStatusEnum role : values()) {
            list.add(role);
        }
        return list;
    }

}
