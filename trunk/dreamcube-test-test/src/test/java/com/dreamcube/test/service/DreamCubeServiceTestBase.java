package com.dreamcube.test.service;

import org.springframework.test.AbstractTransactionalSpringContextTests;

/**
 *                       
 * Filename: DreamCubeServiceTestBase.java
 *
 * Description: 服务测试基类
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
public class DreamCubeServiceTestBase extends AbstractTransactionalSpringContextTests {

    /**
     * @return
     * @see org.springframework.test.AbstractDependencyInjectionSpringContextTests#getConfigLocations()
     */
    @Override
    protected String[] getConfigLocations() {
        String[] config = new String[] { "classpath:/spring/applicationContext-test.xml" };
        return config;
    }

}
