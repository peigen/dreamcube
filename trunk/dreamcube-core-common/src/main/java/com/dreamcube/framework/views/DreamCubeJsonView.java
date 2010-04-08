/**
 * 
 */
package com.dreamcube.framework.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.json.JsonErrorHandler;
import org.springframework.web.servlet.view.json.JsonStringWriter;
import org.springframework.web.servlet.view.json.JsonWriterConfiguratorTemplateRegistry;
import org.springframework.web.servlet.view.json.writer.sojo.SojoJsonStringWriter;

/**
 * JsonView
 * 完整的重写了{@link org.springframework.web.servlet.view.json.JsonView}使的可以与
 * {@link org.springframework.web.servlet.view.UrlBasedViewResolver}的派生类一同进行处理
 * @author holly Apr 8, 2010
 *
 */
public class DreamCubeJsonView extends AbstractUrlBasedView {
private static final String DEFAULT_ENCODING = "UTF-8";
	
	public static final String DEFAULT_JSON_CONTENT_TYPE = "application/json";
	private static final String REQUEST_CONTEXT_ATTRIBUTE =  RequestContext.class.toString();
	public static final String DEFAULT_HIJACKSAVE_PREFIX_POSTFIX = "JSON";
	
	private List<JsonErrorHandler> jsonErrors = new ArrayList<JsonErrorHandler>();
	private JsonStringWriter jsonWriter = new SojoJsonStringWriter();
	private String encoding;
	
	private String hijackSafePrefixPostFix = DEFAULT_HIJACKSAVE_PREFIX_POSTFIX;
	private boolean hijackSafe = false;
	
	
	public DreamCubeJsonView(){
		super();
		setRequestContextAttribute(REQUEST_CONTEXT_ATTRIBUTE);
		setContentType(DEFAULT_JSON_CONTENT_TYPE);
		setEncoding(DEFAULT_ENCODING);
	}
	
	@SuppressWarnings("unchecked")
	public void renderMergedOutputModel(Map model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(getContentType());
		response.setCharacterEncoding(encoding);
		RequestContext rc = getRequestContext(model);
		BindingResult br = getBindingResult( model);
		JsonWriterConfiguratorTemplateRegistry configuratorTemplateRegistry = getConfiguratorTemplateRegistry(request);
		
		if(hasErrors(rc, br)){
			populateErrors(model, rc, br);
			triggerJsonErrors(model, rc, br, request, response);
		}
		
		if (hijackSafe)
        {
            response.getWriter().print("/*" + hijackSafePrefixPostFix);
        }
        
		jsonWriter.convertAndWrite(model, configuratorTemplateRegistry, response.getWriter(), br);

        if (hijackSafe)
        {
            response.getWriter().print(hijackSafePrefixPostFix + "*/");
        }
	}
	
	@SuppressWarnings("unchecked")
	protected void populateErrors(Map model, RequestContext rc, BindingResult br) {
		
		List<String> globalErrors = new ArrayList<String>();
		for (Object er: br.getGlobalErrors()){
			ObjectError error = (ObjectError)er;
			String message = rc.getMessage(error);
			globalErrors.add(message);
		}
		
		model.put("hasGlobalErrors", br.hasGlobalErrors());
		if(!globalErrors.isEmpty())
			model.put("globalerrors", globalErrors);
		
		
		Map<String, String> feldErrors = new HashMap<String, String>();
		for (Object er: br.getFieldErrors()){
			FieldError error = (FieldError)er;
			String objName = error.getField();
			String message = rc.getMessage(error);
			feldErrors.put(objName, message);
		}
		
		model.put("hasFieldErrors", br.hasFieldErrors());
		if(!feldErrors.isEmpty())
			model.put("fielderrors", feldErrors);
		
		
	}

	protected boolean hasErrors(RequestContext rc, BindingResult br) {
		if(br == null)
			return false;
		return br.hasErrors();
	}

	@SuppressWarnings("unchecked")
	protected void triggerJsonErrors(Map model, RequestContext rc,
			BindingResult br, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(jsonErrors == null || jsonErrors.size() == 0)
			return;
		
		for(JsonErrorHandler error: jsonErrors){
				error.triggerError(model, rc, br, request, response);
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	protected  BindingResult getBindingResult(Map model){
		for(Object key : model.keySet() ){
		    if(((String)key).startsWith(BindingResult.MODEL_KEY_PREFIX))
			return (BindingResult) model.remove(key);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected  RequestContext getRequestContext(Map model){
		return (RequestContext) model.remove(getRequestContextAttribute());
	}
	
	protected  JsonWriterConfiguratorTemplateRegistry getConfiguratorTemplateRegistry(HttpServletRequest request){
		return JsonWriterConfiguratorTemplateRegistry.load(request);
	}

	public List<JsonErrorHandler> getJsonErrors() {
		return jsonErrors;
	}

	public void setJsonErrors(List<JsonErrorHandler> jsonErrors) {
		this.jsonErrors = jsonErrors;
	}

	public JsonStringWriter getJsonWriter() {
		return jsonWriter;
	}

	public void setJsonWriter(JsonStringWriter jsonWriter) {
		this.jsonWriter = jsonWriter;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public boolean getHijackSafe() {
		return hijackSafe;
	}

	public void setHijackSafe(boolean hijackSafe) {
		this.hijackSafe = hijackSafe;
	}

	public String getHijackSafePrefixPostFix() {
		return hijackSafePrefixPostFix;
	}

	public void setHijackSafePrefixPostFix(String hijackSafePrefixPostFix) {
		this.hijackSafePrefixPostFix = hijackSafePrefixPostFix;
	}
	
	
}
