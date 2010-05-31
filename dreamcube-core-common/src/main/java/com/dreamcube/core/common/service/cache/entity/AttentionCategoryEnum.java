package com.dreamcube.core.common.service.cache.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * Filename: AttentionCategoryEnum.java
 *
 * Description: 关注类别
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
 *<li>Date: 2010-5-29</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public enum AttentionCategoryEnum {

    SQUAD("SQUAD", "团队关注度"),

    USER("USER", "用户关注度"),

    PROJECT("PROJECT", "项目关注度");

    private final String code;

    private final String message;

    /**
     * @param code
     * @param message
     */
    private AttentionCategoryEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return Returns the code.
     */
    public String code() {
        return code;
    }

    /**
     * @return Returns the message.
     */
    public String message() {
        return message;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     * @param code
     * @return
     */
    public static AttentionCategoryEnum getByCode(String code) {
        for (AttentionCategoryEnum cacheCode : values()) {
            if (cacheCode.getCode().equals(code)) {
                return cacheCode;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     * 
     * @return
     */
    public List<AttentionCategoryEnum> getAllEnum() {
        List<AttentionCategoryEnum> list = new ArrayList<AttentionCategoryEnum>();
        for (AttentionCategoryEnum cache : values()) {
            list.add(cache);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     * 
     * @return
     */
    public List<String> getAllEnumCode() {
        List<String> list = new ArrayList<String>();
        for (AttentionCategoryEnum cache : values()) {
            list.add(cache.code());
        }
        return list;
    }
}
