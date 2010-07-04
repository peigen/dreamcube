/**
 * 
 */
package com.dreamcube.framework.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * BeanToolManager 关于beantool的管理类
 * 
 * @author holly May 26, 2010
 * 
 */
public class BeanToolManager implements ApplicationContextAware, InitializingBean {
    private Map<String, BeanTool> beanTools     = new HashMap<String, BeanTool>();

    private ArrayList<String>     beanToolsList = new ArrayList<String>();

    private ApplicationContext    applicationContext;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.context.ApplicationContextAware#setApplicationContext
     * (org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public ArrayList<String> getBeanToolsList() {
        return beanToolsList;
    }

    public void setBeanToolsList(ArrayList<String> beanToolsList) {
        this.beanToolsList = beanToolsList;
    }

    public Map<String, BeanTool> getBeanTools() {
        return beanTools;
    }

    public void setBeanTools(Map<String, BeanTool> beanTools) {
        this.beanTools = beanTools;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public void afterPropertiesSet() throws Exception {
        Iterator<String> iterator = beanToolsList.iterator();
        for (; iterator.hasNext();) {
            String tool = iterator.next();
            Class toolClass = Class.forName(tool);
            BeanTool beanTool = (BeanTool) toolClass.newInstance();
            this.beanTools.put(beanTool.getToolKey(), beanTool);
        }
    }

}
