package com.dreamcube.core.common.service.cache;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * Filename: LocalCacheEnum.java
 *
 * Description: 缓存说明枚举
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
 *<li>Date: 2010-4-25</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public enum LocalCacheEnum {
    SQUAD_ATTENTION("SQUAD_ATTENTION", "团队关注度"),

    DC_SQUAD("DC_SQUAD", "团队"),

    DC_USER("DC_USER", "用户");

    private final String code;

    private final String message;

    /**
     * @param code
     * @param message
     */
    private LocalCacheEnum(String code, String message) {
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
    public static LocalCacheEnum getByCode(String code) {
        for (LocalCacheEnum cacheCode : values()) {
            if (cacheCode.getCode().equals(code)) {
                return cacheCode;
            }
        }
        return null;
    }

    /**
     * 获取全部缓存
     * 
     * @return
     */
    public List<LocalCacheEnum> getAllRole() {
        List<LocalCacheEnum> list = new ArrayList<LocalCacheEnum>();
        for (LocalCacheEnum cache : values()) {
            list.add(cache);
        }
        return list;
    }

}
