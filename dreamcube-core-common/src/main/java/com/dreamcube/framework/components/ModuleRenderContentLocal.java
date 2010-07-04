/**
 * 
 */
package com.dreamcube.framework.components;

/**
 * ModuleRender内部调用include渲染了页面之后，DispatcherServlet会将request下的所有attributes清除，故需要
 * 将渲染的内容临时保存在当前threadlocal变量中
 * @author holly Jun 8, 2010
 *
 */
public class ModuleRenderContentLocal {
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    public static void addModuleRenderContent(Object object) {
        threadLocal.set(object);
    }

    public static Object getModuleRenderContext() {
        return threadLocal.get();
    }
}
