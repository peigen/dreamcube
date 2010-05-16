package com.dreamcube.core.common.util.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * Filename: GenderEnum.java
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
 *<li>Date: 2010-5-15</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public enum GenderEnum {

    MALE("1", "男"), FEMALE("0", "女");

    private final String code;

    private final String message;

    /**
     * @param code
     * @param message
     */
    private GenderEnum(String code, String message) {
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
    public static GenderEnum getByCode(String code) {
        for (GenderEnum em : values()) {
            if (em.getCode().equals(code)) {
                return em;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     * 
     * @return
     */
    public List<GenderEnum> getAllEnum() {
        List<GenderEnum> list = new ArrayList<GenderEnum>();
        for (GenderEnum cache : values()) {
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
        for (GenderEnum cache : values()) {
            list.add(cache.code());
        }
        return list;
    }
}
