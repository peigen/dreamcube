package com.dreamcube.squad.controller;

import java.util.Date;

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
    private Logger       log = LoggerFactory.getLogger(SquadController.class);

    /**
     * method to handle the get method of helloworld
     * @param modelMap
     * @return vm
     */
    @RequestMapping(value = "/squad/show.html", method = RequestMethod.GET)
    public String viewShow(ModelMap modelMap) {
        modelMap.addAttribute("time", new Date());
        return "squad/show.vm";
    }

    @RequestMapping(value = "/squad/add.html", method = RequestMethod.GET)
    public String viewAdd(ModelMap modelMap) {

        return "squad/add.vm";
    }

    @RequestMapping(value = "/squad/edit.html", method = RequestMethod.POST)
    public String edit(ModelMap modelMap, SquadForm squadForm) {

        try {
            squadService.addSquad(covert(squadForm));
        } catch (Exception e) {
            log.error("", e);
        }
        modelMap.addAttribute("time", new Date());
        return "squad/show.vm";
    }

    /**
     * 
     * @param form
     * @return
     */
    private DCSquad covert(SquadForm form) {
        DCSquad squad = new DCSquad(form.getSquadName(), form.getSquadDesc(), form.getAxiser(),
            form.getInvestors(), form.getStatus());

        return squad;
    }

    // ~~~DI
    public void setSquadService(SquadService squadService) {
        this.squadService = squadService;
    }

}
