package com.dreamcube.core.common.service.cache;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * Filename: CacheOrderByEnum.java
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
 *<li>Date: 2010-5-31</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public enum CacheOrderByEnum {
    ASC(1, "正序"), DESC(-1, "逆序");

    private final int    code;

    private final String message;

    /**
     * @param code
     * @param message
     */
    private CacheOrderByEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the code.
     */
    public int getCode() {
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
    public int code() {
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
    public static CacheOrderByEnum getByCode(int code) {
        for (CacheOrderByEnum cacheCode : values()) {
            if (cacheCode.getCode() == code) {
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
    public List<CacheOrderByEnum> getAllEnum() {
        List<CacheOrderByEnum> list = new ArrayList<CacheOrderByEnum>();
        for (CacheOrderByEnum cache : values()) {
            list.add(cache);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     * 
     * @return
     */
    public List<Integer> getAllEnumCode() {
        List<Integer> list = new ArrayList<Integer>();
        for (CacheOrderByEnum cache : values()) {
            list.add(cache.code());
        }
        return list;
    }
}
