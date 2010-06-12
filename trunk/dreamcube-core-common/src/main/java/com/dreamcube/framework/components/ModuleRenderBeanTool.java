/**
 * 
 */
package com.dreamcube.framework.components;

import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.RequestToViewNameTranslator;

/**
 *模块渲染beanTool，使用方法： 在vm页面上直接写
 * $moduleRender.setTargetModule("/enrollment/login.html")即ok
 * <br>每次请求的时候，dispatcherServlet把handlerMapping, viewResolver,等放入request(这里就需要复写Dispatcher让其支持)
 * <br>在渲染的时候，仿照dispatcherServlet再进行请求一次，不过由于主页面已经渲染完毕，已经进入了context的merge阶段，所以这里
 * <br>会将request的path路径进行修改，修改为targetModule的值。再次进行递归渲染。直至merge完全结束。
 * <br>不知道这样的递归渲染会不会进入死循环？？？ 已经知道的是不能写  A-->B,B-->A这样的页面交叉渲染
 * 
 * @author holly May 27, 2010
 * 
 */
@SuppressWarnings( { "unchecked", "unused" })
public class ModuleRenderBeanTool extends BeanTool {

    private static Logger               logger      = LoggerFactory
                                                        .getLogger(ModuleRenderBeanTool.class);

    private ThreadLocal<String>         threadLocal = new ThreadLocal<String>();

    public static String                TOOL_KEY    = "moduleRender";

    /** List of HandlerMappings used by this servlet */
    private List                        handlerMappings;

    /** List of HandlerAdapters used by this servlet */
    private List                        handlerAdapters;

    /** List of HandlerExceptionResolvers used by this servlet */
    private List                        handlerExceptionResolvers;

    /** RequestToViewNameTranslator used by this servlet */
    private RequestToViewNameTranslator viewNameTranslator;

    /** List of ViewResolvers used by this servlet */
    private List                        viewResolvers;

    /** LocaleResolver used by this servlet */
    private LocaleResolver              localeResolver;

    /** MultipartResolver used by this servlet */
    private MultipartResolver           multipartResolver;

    /**
     * 设置该tool的名称关键字
     */
    @Override
    public String getToolKey() {
        return TOOL_KEY;
    }

    /**
     * 
     * @param targetModule
     *            路径模块名称，需要符合requestMapping
     * @return ModuleRenderBeanTool 本身
     */
    public ModuleRenderBeanTool setTargetModule(String targetModule) {
        threadLocal.set(targetModule);
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.dreamcube.framework.components.BeanTool#render()
     */
    public String render() {
        String targetModule = threadLocal.get();
        try {
            return renderModule(targetModule);
        } catch (Exception e) {
            //:TODO 打印日志
            return ComponentConstants.NONE_CONTENT;
        }

    }

    /**
     * 渲染该模块<br>
     * 
     * @param targetModule
     *            路径模块名称，需要符合requestMapping 并且必须符合context路径标准<br>
     *            <p>
     *                比如 要请求http://www.dreamcube.com/dream/enrollment/index.html则需要写成<br> /dream/enrollment/index.html
     *            </p>
     * @return renderd content
     */
    private String renderModule(String targetModule) throws Exception {

        //do render work
        HttpServletRequest request = this.getRequest();
        HttpServletResponse response = this.getResponse();

        //设置该渲染为moduleRender方式的渲染
        // 在request中设置ComponentConstants.IS_MODULE_RENDERED属性说明是moduleRender的处理
        request.setAttribute(ComponentConstants.IS_MODULE_RENDERED, "true");

        //内部转发进行渲染
        request.getRequestDispatcher(targetModule).include(request, response);

        //获取request中的ComponentConstants.MODULE_REDERDED_CONTENT，此为StringWriter对象

        //	StringWriter writer =  (StringWriter)request.getAttribute(ComponentConstants.MODULE_REDERDED_CONTENT);
        StringWriter writer = (StringWriter) ModuleRenderContentLocal.getModuleRenderContext();
        // 返回渲染的内容
        return writer.getBuffer().toString();
    }

    @Override
    public String toString() {
        return render();
    }

}
