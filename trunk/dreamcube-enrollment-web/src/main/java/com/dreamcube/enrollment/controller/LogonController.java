package com.dreamcube.enrollment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.enrollment.biz.service.EnrollmentService;
import com.dreamcube.enrollment.biz.service.LogonService;
import com.dreamcube.enrollment.form.UserForm;
import com.dreamcube.enrollment.util.UserFormConvert;

/**
 *                       
 * Filename: LogonController.java
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
 *<li>Date: 2010-5-25</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
@Controller
public class LogonController {

    @Autowired
    private LogonService      logonService;

    @Autowired
    private EnrollmentService enrollmentService;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        List<DCUser> users = enrollmentService.loadAttention(3);

        modelMap.addAttribute("users", UserFormConvert.convert(users));

        return "index.vm";
    }

    @RequestMapping(value = "/logon.html", method = RequestMethod.POST)
    public String logon(ModelMap modelMap, UserForm userForm) {
        DCUser user = logonService.logon(UserFormConvert.convert(userForm));

        if (user == null) {
            modelMap.addAttribute("errorMsg", "用户名&密码有误");
        } else {
            modelMap.addAttribute("user", UserFormConvert.convert(user));
        }

        return "index.vm";
    }

    // private
}
