package com.scott.dev.listener.base;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/***
 * 请求监听器，对 request 所有参数进行安全处理
 */
public abstract class AbstractSecureRequestListener extends AbstractRequestListener {

    public AbstractSecureRequestListener() {
        super();
        logger.info("AbstractSecureRequestListener 加载成功...");

    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        super.requestDestroyed(event);
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {

        super.requestInitialized(event);
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();

        trimRequestParam(request);
        doSecureRequest(request);

    }

    /**
     * 过滤请求参数中的左右空格
     * 
     * @param request HttpServletRequest
     */
    protected synchronized void trimRequestParam(HttpServletRequest request) {

        Map<String, String[]> paramMap = request.getParameterMap();
        Set<String> paramSet = paramMap.keySet();

        for (String key : paramSet) {
            String paraName;
            String[] paraValues;
            paraName = key;

            paraValues = request.getParameterValues(paraName);

            if (null != paraValues && paraValues.length > 0) {
                if (paraValues.length > 1) {
                    StringBuffer b = new StringBuffer();
                    for (int i = 0; i < paraValues.length; i++) {
                        String tmpValue = StringUtils.isBlank(paraValues[i]) ? ""
                                : paraValues[i].trim();
                        b.append(tmpValue);
                        if (i != paraValues.length - 1) {
                            b.append(",");
                        }
                    }
                    request.setAttribute(getReqPrefix() + paraName, b.toString());
                } else {
                    if (StringUtils.isNotBlank(paraValues[0])) {
                        logger.info(getReqPrefix() + paraName + " = " + paraValues[0].trim());
                        request.setAttribute(getReqPrefix() + paraName, paraValues[0].trim());
                    } else {
                        logger.info(getReqPrefix() + paraName + " = " + "");
                        request.setAttribute(getReqPrefix() + paraName, "");
                    }
                }
            }
        }
    }

    /**
     * 应用可自行实现的扩展方法
     * 
     * @param request HttpServletRequest
     */
    public abstract void doSecureRequest(HttpServletRequest request);

    /**
     * 放在 reqesut attribute 中的 parameter 的前缀
     * 
     * @return String
     */
    public abstract String getReqPrefix();
}
