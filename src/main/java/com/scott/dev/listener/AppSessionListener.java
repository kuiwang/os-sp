package com.scott.dev.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.scott.dev.listener.base.BaseListener;


public class AppSessionListener extends BaseListener implements HttpSessionListener {

    private static Long sessionCount = 0L;

    /**
     * 存放session的集合类
     */
    protected static Map<String, Object> sessionMap = new HashMap<String, Object>();

    public AppSessionListener() {
        logger.info("AppSessionListener 加载成功...");
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        sessionCount++;

        HttpSession session = event.getSession();
        String sessionId = session.getId();

        logger.info("Create new session: " + sessionId);

        sessionMap.put(sessionId, session);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        if (sessionCount > 0) {
            sessionCount--;
        }

        HttpSession session = event.getSession();
        String sessionId = session.getId();

        //利用会话ID标示特定会话
        sessionMap.remove(sessionId);

        logger.info("Destroy the session: " + sessionId);

    }

    public static Long getSessionCount() {
        return sessionCount;
    }

    public static Map<String, Object> getSessionMap() {
        return sessionMap;
    }

}
