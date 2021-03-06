package com.dreamcube.squad.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dreamcube.core.common.tools.IntegerTool;
import com.dreamcube.core.common.tools.PageList;
import com.dreamcube.core.common.tools.StringTool;
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

    @RequestMapping(value = "/squad/squadQuery.html", method = RequestMethod.GET)
    public String viewQuery(ModelMap modelMap) {

        return "squad/squadQuery.vm";
    }

    @RequestMapping(value = "/squad/doSquadQueryCache.html", method = RequestMethod.POST)
    public String doQueryCache(ModelMap modelMap, SquadForm squadForm) {

        List<DCSquad> list = squadService.queryAllSquadCache();
        modelMap.addAttribute("squadList", list);
        modelMap.addAttribute("squad", squadForm);
        return "squad/squadQuery.vm";
    }

    @RequestMapping(value = "/squad/doSquadQuery.html", method = RequestMethod.POST)
    public String doQuery(ModelMap modelMap, SquadForm squadForm) {

        PageList pagelist = squadService.querySquad(squadForm.getSquadName(),
            squadForm.getAxiser(), squadForm.getCubers(), squadForm.getFollowers(),
            squadForm.getInvestors(), squadForm.getStatus(), squadForm.getGmtCreate(),
            squadForm.getGmtModify(), IntegerTool.strToInt(squadForm.getPageSize()),
            IntegerTool.strToInt(squadForm.getPageNum()));

        modelMap.addAttribute("squadList", pagelist);
        modelMap.addAttribute("squad", squadForm);

        return "squad/squadQuery.vm";
    }

    @RequestMapping(value = "/squad/squadEdit.html", method = RequestMethod.GET)
    public String viewEdit(ModelMap modelMap, SquadForm squadForm) {

        if (StringTool.isNotBlank(squadForm.getId())) {
            DCSquad squad = squadService.loadById(squadForm.getId());

            modelMap.addAttribute("squad", SquadFormConvert.convert(squad));
        }
        return "squad/squadEdit.vm";
    }

    @RequestMapping(value = "/squad/doEdit.html", method = RequestMethod.POST)
    public String doEdit(ModelMap modelMap, SquadForm squadForm) {

        squadService.editSquad(SquadFormConvert.convert(squadForm));

        return doQuery(modelMap, squadForm);
    }

    @RequestMapping(value = "/squad/doDelete.html", method = RequestMethod.POST)
    public String doDelete(ModelMap modelMap, SquadForm squadForm) {

        squadService.removeSquad(squadForm.getId());

        return "squad/squadQuery.vm";
    }

}
