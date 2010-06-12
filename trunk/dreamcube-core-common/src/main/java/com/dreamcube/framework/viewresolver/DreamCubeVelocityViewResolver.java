/**
 * 
 */
package com.dreamcube.framework.viewresolver;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

import com.dreamcube.framework.components.BeanToolManager;
import com.dreamcube.framework.views.DreamCubeVelocityView;

/**
 * @author holly May 26, 2010
 *
 */
public class DreamCubeVelocityViewResolver extends VelocityLayoutViewResolver {
    private BeanToolManager beanToolManager;

    /**
     * Requires DreamCubeVelocityView.
     * @see DreamCubeVelocityView
     */
    @Override
    protected Class<?> requiredViewClass() {
        return DreamCubeVelocityView.class;
    }

    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        DreamCubeVelocityView view = (DreamCubeVelocityView) super.buildView(viewName);
        view.setBeanToolManager(beanToolManager);
        return view;
    }

    public void setBeanToolManager(BeanToolManager beanToolManager) {
        this.beanToolManager = beanToolManager;
    }

}
