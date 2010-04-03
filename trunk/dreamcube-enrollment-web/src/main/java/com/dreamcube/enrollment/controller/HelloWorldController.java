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
@Controller
public class HelloWorldController {
	
	/**
	 * method to handle the get method of helloworld
	 * @param modelMap
	 * @return vm
	 */
	@RequestMapping(value="/enrollment/helloworld.html",method = RequestMethod.GET)
	public String doGet(ModelMap modelMap){
		modelMap.addAttribute("time", new Date());
		return "enrollment/helloWorld.vm";
	}
}
