/**
 * 
 */
package com.dreamcube.framework.views;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

import com.dreamcube.framework.components.BeanTool;
import com.dreamcube.framework.components.BeanToolManager;
import com.dreamcube.framework.components.ComponentConstants;
import com.dreamcube.framework.components.ModuleRenderContentLocal;

/**
 * 继承自 {@link org.springframework.web.servlet.view.velocity.VelocityLayoutView
 * VelocityLayoutView} 增加了ToolBean功能，内部对ToolBox的局限功能进行了扩展
 * 
 * @author holly May 26, 2010
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class DreamCubeVelocityView extends VelocityLayoutView {
    private BeanToolManager beanToolManager;

    /**
     * 通过复写此方法来达到支持ModuleRender的内部render
     * <ul>
     * <li>通过检测request里面有key=
     * {@link com.dreamcube.framework.components.ComponentConstants#IS_MODULE_RENDERED
     * ComponentConstants.IS_MODULE_RENDERED}的值，确定是将内容渲染到StringBuffer里，还是正常模式</li>
     * <li>如果是StringBuffer方式，则会将渲染后的内容作为key=
     * {@link com.dreamcube.framework.components.ComponentConstants#MODULE_REDERDED_CONTENT
     * ComponentConstants.MODULE_REDERDED_CONTENT}放到request的attribute中</li>
     * <li>key=key=
     * {@link com.dreamcube.framework.components.ComponentConstants#IS_MODULE_RENDERED
     * ComponentConstants.IS_MODULE_RENDERED}的这个值是在
     * {@link com.dreamcube.framework.components.ModuleRenderBeanTool#renderModule
     * renderModule}方法中设置的</li>
     * </ul>
     */
    @Override
    protected void renderMergedTemplateModel(Map model, HttpServletRequest request,
                                             HttpServletResponse response) throws Exception {
        // 如果request里面有key=moduleRendered的值，则将render的方式更改为写StringBuffer的方式，并
        // 将该stringbuffer返回到request里面以供moduleRender渲染； 否则就执行velocity默认的渲染方式
        if (StringUtils.isNotEmpty((String) request
            .getAttribute(ComponentConstants.IS_MODULE_RENDERED))) {

            this.renderModuleMergedTemplateModel(model, request, response);

        } else {
            /** 在暴露了各种工具之后，需要将response也暴露到 */
            exposeHelpers(model, request, response);
            super.renderMergedTemplateModel(model, request, response);
        }
    }

    /**
     * 渲染module模板
     * 
     * @param model
     * @param request
     * @param response
     */
    private void renderModuleMergedTemplateModel(Map model, HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        /** 在暴露了各种工具之后，需要将response也暴露到 */
        exposeHelpers(model, request, response);

        Context velocityContext = createVelocityContext(model, request, response);
        exposeHelpers(velocityContext, request, response);
        exposeToolAttributes(velocityContext, request);

        Template template = this.getTemplate();
        StringWriter writer = new StringWriter();
        template.merge(velocityContext, writer);
        ModuleRenderContentLocal.addModuleRenderContent(writer);
        //		request
        //				.setAttribute(ComponentConstants.MODULE_REDERDED_CONTENT,
        //						writer);

    }

    /**
     * 暴露工具类的helper方法
     * 
     * @param model
     * @param request
     * @param response
     */
    private void exposeHelpers(Map model, HttpServletRequest request, HttpServletResponse response)
                                                                                                   throws Exception {
        model.put("responseTempKey", response);

    }

    /**
     * 重写该方法使起支持ToolBean暴露到context中
     */
    @Override
    protected void exposeHelpers(Map model, HttpServletRequest request) throws Exception {
        Map<String, BeanTool> beanToolMap = beanToolManager.getBeanTools();
        Iterator<Entry<String, BeanTool>> iterator = beanToolMap.entrySet().iterator();

        for (; iterator.hasNext();) {
            Entry<String, BeanTool> entry = iterator.next();
            // 复制一份放入页面
            BeanTool cloned = (BeanTool) BeanUtils.cloneBean(entry.getValue());
            cloned.setRequest(request);
            /** 如果model里面有responseTempKey则说明是模块渲染的，则需要往BeanTool里面放reponse */
            if (model.get("responseTempKey") != null) {
                HttpServletResponse response = (HttpServletResponse) model.get("responseTempKey");
                cloned.setResponse(response);
            }
            model.put(entry.getKey(), cloned);

        }
        super.exposeHelpers(model, request);
    }

    // ~~~~~~~~~setter and getter
    public BeanToolManager getBeanToolManager() {
        return beanToolManager;
    }

    public void setBeanToolManager(BeanToolManager beanToolManager) {
        this.beanToolManager = beanToolManager;
    }

}
