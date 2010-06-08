/**
 * 
 */
package com.dreamcube.framework.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BeanTool的接口
 * 
 * @author holly May 27, 2010
 * 
 */
public abstract class BeanTool {

	private HttpServletRequest request = null;
	
	private HttpServletResponse response = null;


	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 
	 * @return TOOL_KEY tool的名称
	 */
	public abstract String getToolKey();

	/**
	 * 初始化方法
	 * 
	 * @param beanToolManager
	 *            beantool管理器
	 */
	public void init(BeanToolManager beanToolManager) {
	}

}
