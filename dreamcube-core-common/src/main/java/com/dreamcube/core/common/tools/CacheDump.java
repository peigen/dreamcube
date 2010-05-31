package com.dreamcube.core.common.tools;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dreamcube.core.common.service.cache.LocalCache;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;

/**
 *                       
 * Filename: CacheDump.java
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
 *<li>Date: 2010-4-25</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class CacheDump {

    public static final String SEPARATOR = "-----------------------";

    public static final String ENTERSTR  = "\n";

    private static Logger      log       = LoggerFactory.getLogger(CacheDump.class);

    /**
     * @param localCache
     * @return
     */
    public static String dump(LocalCache localCache) {

        LocalCacheEnum localCacheEnum = localCache.getCacheName();

        String cacheName = localCacheEnum.message();

        try {

            if (log.isInfoEnabled()) {

                StringBuffer sb = new StringBuffer();

                sb.append(ENTERSTR + SEPARATOR + "开始输出缓存" + cacheName + "信息" + SEPARATOR);

                //TODO

                sb.append(ENTERSTR + SEPARATOR + "结束输出缓存" + cacheName + "信息" + SEPARATOR);

                log.info(sb.toString());
                return sb.toString();
            }

        } catch (Exception e) {
            log.warn("本地缓存对象打印异常[" + cacheName + "]：", e);
        }

        return null;
    }

    /**
     * 对于Map<String, Object>的类型转换
     * 
     * @param Map<String, Object>
     * @return StringBuffer
     */

    @SuppressWarnings("unchecked")
    public static StringBuffer mapStringAndObject(Map map) {

        StringBuffer cacheMessage = new StringBuffer();

        for (Iterator<String> i = map.keySet().iterator(); i.hasNext();) {

            String name = i.next();

            cacheMessage.append(ENTERSTR
                                + "["
                                + name
                                + "={"
                                + ToStringBuilder.reflectionToString(map.get(name),
                                    ToStringStyle.SHORT_PREFIX_STYLE) + "}]");

        }
        return cacheMessage;
    }

    /**
     * 对于List<Object>的类型转换
     * 
     * @param List<Object>
     * @return StringBuffer
     */
    @SuppressWarnings("unchecked")
    public static StringBuffer listObject(List list) {

        StringBuffer cacheMessage = new StringBuffer();

        for (Object data : list) {

            cacheMessage.append(ENTERSTR + "["

            + ToStringBuilder.reflectionToString(data, ToStringStyle.SHORT_PREFIX_STYLE) + "]");
        }
        return cacheMessage;
    }

    /**
     * 对于Map<String, List<String>>的类型转换
     * 
     * @param Map<String, List<String>>
     * @return StringBuffer
     */
    public static StringBuffer mapStringAndListString(Map<String, List<String>> map) {

        StringBuffer cacheMessage = new StringBuffer();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {

            cacheMessage.append(ENTERSTR + "[" + entry.getKey() + "={");

            for (String s : entry.getValue()) {

                cacheMessage.append("|" + s);

            }
            cacheMessage.append("}]");

        }
        return cacheMessage;
    }

    /**
     * 对于Map<String, String>的类型转换
     * 
     * @param Map<String, String>
     * @return StringBuffer
     */

    @SuppressWarnings("unchecked")
    public static StringBuffer mapStringAndString(Map map) {

        StringBuffer cacheMessage = new StringBuffer();

        for (Iterator<String> i = map.keySet().iterator(); i.hasNext();) {

            String name = i.next();

            cacheMessage.append(ENTERSTR + "[" + name + "=" + map.get(name) + "]");

        }
        return cacheMessage;
    }

    /**
     * 对于List<String>的类型转换
     * 
     * @param List<String>
     * @return StringBuffer
     */
    public static StringBuffer listString(List<String> list) {

        StringBuffer cacheMessage = new StringBuffer();

        for (String s : list) {

            cacheMessage.append(ENTERSTR + "[" + s + "]");
        }
        return cacheMessage;
    }

}
