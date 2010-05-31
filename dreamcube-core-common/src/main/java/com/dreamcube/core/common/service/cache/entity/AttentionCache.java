package com.dreamcube.core.common.service.cache.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *                       
 * Filename: AttentionCache.java
 *
 * Description: 关注度缓存对象
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
public class AttentionCache {

    private String                key;

    private String                name;

    private long                  times;

    private AttentionCategoryEnum category;

    /**
     * 
     */
    public AttentionCache() {
        super();
    }

    /**
     * @param key
     * @param name
     * @param times
     * @param category
     */
    public AttentionCache(String key, String name, long times, AttentionCategoryEnum category) {
        super();
        this.key = key;
        this.name = name;
        this.times = times;
        this.category = category;
    }

    /**
     * @return Returns the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     * The key to set.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return Returns the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the times
     */
    public long getTimes() {
        return times;
    }

    /**
     * @param times
     * The times to set.
     */
    public void setTimes(long times) {
        this.times = times;
    }

    /**
     * @return Returns the category
     */
    public AttentionCategoryEnum getCategory() {
        return category;
    }

    /**
     * @param category
     * The category to set.
     */
    public void setCategory(AttentionCategoryEnum category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
