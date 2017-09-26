package com.scott.dev.listener.base;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.scott.dev.holder.AppRequestHolder;

/***
 * 请求监听器，把 request 对象放在静态类中供java类调用
 */

public abstract class AbstractRequestListener extends BaseListener
        implements ServletRequestListener {

    public AbstractRequestListener() {
        super();
        logger.info("AbstractRequestListener 加载成功...");
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        AppRequestHolder.setRequest(request);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        AppRequestHolder.getRequestHolder().remove();
    }
}
