package com.dreamcube.core.common.service.cache.entity;

import java.io.Serializable;

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
public class AttentionCache implements Serializable {

    private static final long     serialVersionUID = -6035319696849752802L;

    private String                id;

    private String                name;

    private long                  times;

    private AttentionCategoryEnum attentionCategory;

    /**
     * 
     */
    public AttentionCache() {
        super();
    }

    /**
     * @param id
     * @param name
     * @param times
     * @param attentionCategory
     */
    public AttentionCache(String id, String name, long times,
                          AttentionCategoryEnum attentionCategory) {
        super();
        this.id = id;
        this.name = name;
        this.times = times;
        this.attentionCategory = attentionCategory;
    }

    /**
     * @return Returns the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     * The id to set.
     */
    public void setId(String id) {
        this.id = id;
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
     * @return Returns the attentionCategory
     */
    public AttentionCategoryEnum getAttentionCategory() {
        return attentionCategory;
    }

    /**
     * @param attentionCategory
     * The attentionCategory to set.
     */
    public void setAttentionCategory(AttentionCategoryEnum attentionCategory) {
        this.attentionCategory = attentionCategory;
    }

    /**
     * @param attentionCategory
     * The attentionCategory to set.
     */
    public void setAttentionCategoryByEnum(AttentionCategoryEnum attentionCategory) {
        this.attentionCategory = attentionCategory;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
