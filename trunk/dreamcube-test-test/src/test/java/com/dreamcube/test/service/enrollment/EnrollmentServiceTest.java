package com.dreamcube.test.service.enrollment;

import java.util.List;

import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.test.service.DreamCubeServiceTestBase;

/**
 *                       
 * Filename: EnrollmentServiceTest.java
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
 *<li>Date: 2010-9-4</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
public class EnrollmentServiceTest extends DreamCubeServiceTestBase {

    public void testCreateUser() {
        String logonName = "peigen";
        String logonPasswd = "peigen";
        DCUser user = new DCUser(logonName, logonPasswd);

        user.check();

        enrollmentService.editUser(user);

        assertEquals(false, enrollmentService.vaildUserName(logonName, logonName));

    }

    public void testLoadAllUserName() {
        testCreateUser();

        List<String> userNames = enrollmentService.loadAllUserName();

        print(userNames);

        assertEquals(true, userNames.size() > 0);

    }

    // private

}
