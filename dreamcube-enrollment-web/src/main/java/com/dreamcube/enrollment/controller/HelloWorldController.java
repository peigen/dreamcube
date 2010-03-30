package com.dreamcube.enrollment.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Hello world!
 *
 */
@Controller(value="/enrollment/helloworld.htm")
public class HelloWorldController {
	
	/**
	 * method to handle the get method of helloworld
	 * @param modelMap
	 * @return vm
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap modelMap){
		modelMap.addAttribute("time", new Date());
		return "helloWord.vm";
	}
}
