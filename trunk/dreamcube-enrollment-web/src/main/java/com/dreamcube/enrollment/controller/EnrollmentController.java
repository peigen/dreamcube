package com.dreamcube.enrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dreamcube.core.common.tools.IntegerTool;
import com.dreamcube.core.common.tools.StringTool;
import com.dreamcube.core.dal.util.PageList;
import com.dreamcube.core.enrollment.domain.DCUser;
import com.dreamcube.enrollment.biz.service.EnrollmentService;
import com.dreamcube.enrollment.form.UserForm;
import com.dreamcube.enrollment.util.UserFormConvert;

/**
 *                       
 * Filename: EnrollmentController.java
 *
 * Description: 注册模块
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
 *<li>Date: 2010-5-10</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @RequestMapping(value = "/enrollment/enrollmentQuery.html", method = RequestMethod.GET)
    public String viewQuery(ModelMap modelMap) {

        return "enrollment/enrollmentQuery.vm";
    }

    @RequestMapping(value = "/enrollment/doQuery.html", method = RequestMethod.POST)
    public String doQuery(ModelMap modelMap, UserForm userForm) {

        PageList list = enrollmentService.queryUser(userForm.getLogonName(),
            userForm.getNickName(), userForm.getCertNo(), userForm.getStatus(), userForm
                .getGmtCreate(), userForm.getGmtModify(), IntegerTool.strToInt(userForm
                .getPageSize()), IntegerTool.strToInt(userForm.getPageNum()));

        modelMap.addAttribute("userList", list);
        modelMap.addAttribute("user", userForm);
        return "enrollment/enrollmentQuery.vm";
    }

    @RequestMapping(value = "/enrollment/enrollmentEdit.html", method = RequestMethod.GET)
    public String viewEdit(ModelMap modelMap, UserForm userForm) {

        String userId = userForm.getId();
        if (StringTool.isNotBlank(userId)) {

            DCUser user = enrollmentService.loadById(userId);
            modelMap.addAttribute("user", UserFormConvert.convert(user));
        }

        return "enrollment/enrollmentEdit.vm";
    }

    @RequestMapping(value = "/enrollment/doEdit.html", method = RequestMethod.POST)
    public String doEdit(ModelMap modelMap, UserForm userForm) {

        enrollmentService.editUser(UserFormConvert.convert(userForm));

        return doQuery(modelMap, userForm);
    }

    @RequestMapping(value = "/enrollment/doDelete.html", method = RequestMethod.POST)
    public String doDelete(ModelMap modelMap, UserForm userForm) {

        enrollmentService.removeUser(userForm.getId());

        return "squad/squadQuery.vm";
    }
}
