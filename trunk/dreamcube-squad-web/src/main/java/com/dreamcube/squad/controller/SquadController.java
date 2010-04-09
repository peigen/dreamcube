package com.dreamcube.squad.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dreamcube.core.squad.domain.DCSquad;
import com.dreamcube.squad.biz.service.SquadService;
import com.dreamcube.squad.form.SquadForm;
import com.dreamcube.squad.util.SquadFormConvert;

/**
 *                       
 *Filename: SquadController.java
 *
 *Description: 
 *
 *Version: 0.1
 *
 *Author: peigen
 *
 *Email: peigen123@gmail.com
 *
 *Blog: http://peigen.info
 *
 *       
 *History:<br>
 *<li>Author: peigen</li>
 *<li>Date: 2010-4-5</li>
 *<li>Version: 0.1</li>
 *<li>Content: create</li>
 *
 */
@Controller
public class SquadController {
    @Autowired
    private SquadService squadService;

    @SuppressWarnings("unused")
    private Logger       log = LoggerFactory.getLogger(SquadController.class);

    @RequestMapping(value = "/squad/show.html", method = RequestMethod.GET)
    public String viewShow(ModelMap modelMap) {
        modelMap.addAttribute("time", new Date());
        return "squad/show.vm";
    }

    @RequestMapping(value = "/squad/add.html", method = RequestMethod.GET)
    public String viewAdd(ModelMap modelMap) {

        return "squad/add.vm";
    }

    @RequestMapping(value = "/squad/doEdit.html", method = RequestMethod.POST)
    public String doEdit(ModelMap modelMap, SquadForm squadForm) {

        squadService.editSquad(SquadFormConvert.covert(squadForm));

        return list(modelMap);
    }

    @RequestMapping(value = "/squad/edit.html", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, SquadForm squadForm) {

        DCSquad squad = squadService.loadById(squadForm.getId());

        modelMap.addAttribute("squad", SquadFormConvert.covert(squad));

        return "squad/edit.vm";
    }

    @RequestMapping(value = "/squad/list.html", method = RequestMethod.GET)
    public String list(ModelMap modelMap) {

        List<DCSquad> list = squadService.queryAllSquad();
        modelMap.addAttribute("squadList", list);
        return "squad/list.vm";
    }

    // private method

}
