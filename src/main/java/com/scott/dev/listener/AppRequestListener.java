package com.scott.dev.listener;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.scott.dev.common.AppConstant;
import com.scott.dev.config.AppConfiguration;
import com.scott.dev.helper.AppRequestHelper;
import com.scott.dev.listener.base.AbstractSecureRequestListener;

public class AppRequestListener extends AbstractSecureRequestListener {

    private static final String appDebug;

    private static final String appJsLogEnabled;

    private static final String appTimestamp;

    private static final String appVersion;

    static {

        appDebug = AppConfiguration.get(AppConstant.APP_ENV_DEBUG);

        appTimestamp = AppConfiguration.get(AppConstant.APP_ENV_TIMESTAMP);

        appVersion = AppConfiguration.get(AppConstant.APP_ENV_VERSION);

        appJsLogEnabled = AppConfiguration.get(AppConstant.APP_ENV_JS_LOG_ENBALED);
    }

    public AppRequestListener() {
        super();
        logger.info("AppRequestListener 加载成功...");
    }

    @Override
    public void doSecureRequest(HttpServletRequest request) {

        request.setAttribute("version", "sp#openshift");
        request.setAttribute("sysTimestamp", String.valueOf(System.currentTimeMillis()));

        // debug 模式每次刷新
        request.setAttribute("commonAppTimestamp", appTimestamp);

        request.setAttribute("commonAppVersion", appVersion);
        request.setAttribute("commonAppJsLogEnabled", appJsLogEnabled);

        String appPath = AppRequestHelper.getContextPath(request);
        String appBase = AppRequestHelper.getContextBase(request);

        if (StringUtils.isBlank(appPath)) {
            appPath = appBase;
        }

        request.setAttribute("commonAppPath", appPath);
        request.setAttribute("commonAppBase", appBase);

    }

    @Override
    public String getReqPrefix() {
        return AppRequestHelper.REQ_PREFIX;
    }

}
