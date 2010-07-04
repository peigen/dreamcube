package com.dreamcube.test.service.common.cache;

import java.util.List;

import com.dreamcube.core.common.service.cache.CacheKeyNameEnum;
import com.dreamcube.core.common.service.cache.CacheTool;
import com.dreamcube.core.common.service.cache.LocalCacheEnum;
import com.dreamcube.core.common.tools.ByteTool;
import com.dreamcube.core.dal.dataobject.DcSquadDO;
import com.dreamcube.squad.biz.convert.SquadConvert;
import com.dreamcube.test.service.DreamCubeServiceTestBase;
import com.mongodb.BasicDBObject;

/**
 *                       
 * Filename: MongoDBStoreServiceTest.java
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
public class MongoDBStoreServiceTest extends DreamCubeServiceTestBase {

    /**
     * 初始化缓存对象
     */
    public void testStoreCache() {
        List<DcSquadDO> squadDOList = dcSquadDAO.load();

        print("清空缓存对象");
        cacheService.clean(LocalCacheEnum.DC_SQUAD);

        print("创建缓存对象");
        cacheService.refresh(LocalCacheEnum.DC_SQUAD, CacheKeyNameEnum.SQUAD,
            SquadConvert.doToDomainListForSerializ(squadDOList));

    }

    /**
     * 查询缓存对象
     * @throws Exception 
     */
    public void testQueryCache() throws Exception {
        print("查询缓存对象");
        List<?> cacheList = cacheService.getAllCacheObject(LocalCacheEnum.DC_SQUAD);

        assertEquals(true, cacheList.size() > 0);

        for (Object object : cacheList) {
            print(object.toString());
            transDCObject(object);
        }
    }

    /**
     * @param obj
     * @throws Exception 
     */
    private void transDCObject(Object obj) throws Exception {

        print(ByteTool.getObjectFromBytes((byte[]) ((BasicDBObject) obj).get(CacheTool.CACHE)));

        Object category = ((BasicDBObject) obj).get(CacheTool.CATEGORY);
        print(category);

    }

}
