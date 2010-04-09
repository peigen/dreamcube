/**
 * 
 */
package com.dreamcube.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.dreamcube.core.common.tools.PicCodeGenerateTool;

/**
 * 校验码生成controller
 * @author holly Apr 9, 2010
 *
 */
@Controller
public class PicCodeController {
	@Autowired
	private PicCodeGenerateTool picCodeGenerateTool;
	
	@RequestMapping(value="/picCode.checkcode",method = RequestMethod.GET)
	public String doGetPicCode(WebRequest request,ModelMap modelMap){
		picCodeGenerateTool.generateNewPicAuthCode(request, modelMap);
		return "picCode.checkcode";
	}
}
