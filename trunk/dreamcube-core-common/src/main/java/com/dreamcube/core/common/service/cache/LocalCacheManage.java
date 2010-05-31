package com.dreamcube.core.common.service.cache;


/**
 *                       
 * Filename: LocalCacheManage.java
 *
 * Description: 本地缓存管理服务
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
public interface LocalCacheManage {

    public void init();

    public void refresh(LocalCacheEnum localCache);

}
