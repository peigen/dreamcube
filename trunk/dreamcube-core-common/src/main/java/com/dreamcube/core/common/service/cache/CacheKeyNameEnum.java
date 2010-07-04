package com.dreamcube.core.common.service.cache;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * Filename: CacheKeyNameEnum.java
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
 *<li>Date: 2010-7-4</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public enum CacheKeyNameEnum {
    SQUAD("squad_name", "团队名称"), USER("user_name", "用户名称"), SQUAD_ATTENTION("SQUAD_ATTENTION",
                                                                            "团队关注度");

    private final String code;

    private final String message;

    /**
     * @param code
     * @param message
     */
    private CacheKeyNameEnum(String code, String message) {
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
    public static CacheKeyNameEnum getByCode(String code) {
        for (CacheKeyNameEnum cacheCode : values()) {
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
    public List<CacheKeyNameEnum> getAllEnum() {
        List<CacheKeyNameEnum> list = new ArrayList<CacheKeyNameEnum>();
        for (CacheKeyNameEnum cache : values()) {
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
        for (CacheKeyNameEnum cache : values()) {
            list.add(cache.code());
        }
        return list;
    }
}
