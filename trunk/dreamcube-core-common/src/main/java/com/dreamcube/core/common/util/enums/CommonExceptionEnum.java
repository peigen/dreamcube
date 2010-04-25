package com.dreamcube.core.common.util.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * Filename: CommonErrorEnum.java
 *
 * Description: 通用异常定义
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
public enum CommonExceptionEnum {

    DBOBJECT_PARSE_ERROR("DBOBJECT_PARSE_ERROR", "DBObject解析失败"),

    CACHE_DROP_ERROR("CACHE_DROP_ERROR", "缓存[DROP]失败"),

    CACHE_CLEAN_ERROR("CACHE_CLEAN_ERROR", "缓存[清理]失败"),

    CACHE_REFRESH_ERROR("CACHE_REFRESH_ERROR", "缓存[刷新]失败"),

    CACHE_UPDATE_ERROR("CACHE_UPDATE_ERROR", "缓存[更新]失败");

    private final String code;

    private final String message;

    /**
     * @param code
     * @param message
     */
    private CommonExceptionEnum(String code, String message) {
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
    public static CommonExceptionEnum getByCode(String code) {
        for (CommonExceptionEnum cacheCode : values()) {
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
    public List<CommonExceptionEnum> getAllRole() {
        List<CommonExceptionEnum> list = new ArrayList<CommonExceptionEnum>();
        for (CommonExceptionEnum error : values()) {
            list.add(error);
        }
        return list;
    }
}
