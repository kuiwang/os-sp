package com.scott.dev.holder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 应用的 HttpServletRequest ThreadLocal
 */
public class AppRequestHolder {

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void setRequest(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static HttpServletRequest getRequest() {
        return requestHolder.get();
    }

    public static HttpSession getSession() {
        HttpSession session = null;
        HttpServletRequest request = requestHolder.get();

        if (null != request) {
            session = request.getSession(true);
        }

        return session;
    }

    public static ThreadLocal<HttpServletRequest> getRequestHolder() {
        return requestHolder;
    }

}
