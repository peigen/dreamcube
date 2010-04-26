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

    /** UN_CERTIFIED---未认证 */
    UN_CERTIFIED("UN_CERTIFIED", "未认证");

    private final String code;

    private final String message;

    /**
     * @param code
     * @param message
     */
    private DCUserStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return Returns the code
     */
    public String code() {
        return code;
    }

    /**
     * @return Returns the message
     */
    public String message() {
        return message;
    }

    /**
     * 获取全部用户状态
     * 
     * @return
     */
    public List<DCUserStatusEnum> getAllStatus() {
        List<DCUserStatusEnum> list = new ArrayList<DCUserStatusEnum>();
        for (DCUserStatusEnum status : values()) {
            list.add(status);
        }
        return list;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     * @param code
     * @return
     */
    public static DCUserStatusEnum getByCode(String code) {
        for (DCUserStatusEnum userStatusCode : values()) {
            if (userStatusCode.getCode().equals(code)) {
                return userStatusCode;
            }
        }
        return null;
    }
}
