package com.scott.dev.holder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 从 ServletContext 或 Bean初始化时 获取 spring 上下文
 */
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

    private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

    private static ApplicationContext context;

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        Validate.validState(context != null,
                "context属性未注入, 请在context-root.xml中定义SpringContextHolder.");
    }

    /**
     * 清除AppContextHelper中的ApplicationContext为Null.
     */
    public static void clearHolder() {
        if (logger.isDebugEnabled()) {
            logger.debug("清除SpringContextHolder中的ApplicationContext:" + context);
        }
        context = null;
    }

    /**
     * 返回 Bean初始化时 的 ApplicationContext 取得存储在静态变量中的context.
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return context;
    }

    /**
     * 从 ServletContext 获取 ApplicationContext
     *
     * @param request HttpServletRequest
     * @return ApplicationContext ApplicationContext
     */
    public static ApplicationContext getApplicationContext(HttpServletRequest request) {
        assertContextInjected();
        ServletContext servletContext = request.getSession().getServletContext();
        ApplicationContext context = WebApplicationContextUtils
                .getWebApplicationContext(servletContext);

        return context;

    }

    /**
     * 从静态变量context中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return context.getBean(requiredType);
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) context.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return context.getBean(name, requiredType);
    }

    /**
     * 实现DisposableBean接口, 在Context关闭时清理静态变量.
     */
    @Override
    public void destroy() throws Exception {
        SpringContextHolder.clearHolder();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        logger.info("SpringContextHolder - ApplicationContext[" + applicationContext.getClass().getName()
                + "] inited: " + applicationContext);
    }

}
