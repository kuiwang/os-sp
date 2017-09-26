package com.scott.dev.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.scott.dev.config.AppConfiguration;
import com.scott.dev.listener.base.BaseListener;

/**
 * SpContextListener
 */
public class AppContextListener extends BaseListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        if (logger.isInfoEnabled()) {
            logger.info("will begin init configuration...");
        }
        AppConfiguration.init(servletContextEvent.getServletContext());

        //Executor.executeTask(new DirtyWordsFlushTask());

        if (AppConfiguration.isProductEnv()) {

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
