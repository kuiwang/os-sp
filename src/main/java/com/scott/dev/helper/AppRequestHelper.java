package com.scott.dev.helper;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scott.dev.common.AppConstant;
import com.scott.dev.holder.SpringContextHolder;

public class AppRequestHelper extends SpringContextHolder {

    protected static Logger log = LoggerFactory.getLogger(AppRequestHelper.class);

    public static final String REQ_PREFIX = AppConstant.REQUEST_PREFIX_APP;

    /**
     * 获取应用的 http 绝对路径 <br>
     * 如果应用是基于反向代理后端，则使用https 协议时，传入header SSL, 例如 nginx <br>
     * proxy_set_header SSL ssl; <br>
     *
     * @param request HttpServletRequest
     * @return http 绝对路径
     */
    public static String getContextBase(HttpServletRequest request) {

        String appBase = "";

        // nginx set : proxy_set_header SSL ssl;

        String proxySSl = request.getHeader("SSL");
        String scheme = request.getScheme();
        if (StringUtils.isNotBlank(proxySSl)) {
            //scheme = "https";
            scheme = AppConstant.SCHEME_HTTPS;
        }

        String appPath = getContextPath(request);

        if (AppConstant.HTTP_DEFAULT_PORT != request.getServerPort()) {
            appBase = new StringBuffer(scheme).append("://").append(request.getServerName())
                    .append(":").append(request.getServerPort()).append(appPath).toString();
        } else {
            appBase = new StringBuffer(scheme).append("://").append(request.getServerName())
                    .append(appPath).toString();
        }

        return appBase;

    }

    /**
     * 获取应用的 http 相对路径
     *
     * @param request HttpServletRequest
     * @return http 相对路径
     */
    public static String getContextPath(HttpServletRequest request) {
        String appPath = request.getContextPath();

        // 如果应用部署的站点根目录，则 path 值为空，导致部分URL跳转失效
        if (StringUtils.isBlank(appPath)) {
            appPath = "";
        }

        return appPath;
    }

    /**
     * 解析请求参数
     *
     * @param request HttpServletRequest
     * @return 参数化的 Map
     */
    public static synchronized Map<String, Object> parseRequest(HttpServletRequest request) {
        Map<String, Object> param = new HashMap<String, Object>();
        Object reqAttr = null;
        String attrName, paraName;

        @SuppressWarnings("rawtypes")
        Enumeration attrs = request.getAttributeNames();

        while (attrs.hasMoreElements()) {
            attrName = (String) attrs.nextElement();

            if (null != attrName && attrName.startsWith(REQ_PREFIX)) {

                paraName = attrName.substring(attrName.indexOf(REQ_PREFIX) + REQ_PREFIX.length(),
                        attrName.length());

                reqAttr = request.getAttribute(attrName);

                param.put(paraName, reqAttr);

            }
        }
        return param;

    }

    public static Map<String, Object> parseRequest(HttpServletRequest request, String reqPrefix) {

        Map<String, Object> param = new HashMap<String, Object>();
        Object reqAttr = null;
        String attrName, paraName;

        Enumeration<String> attrs = request.getAttributeNames();

        while (attrs.hasMoreElements()) {
            attrName = attrs.nextElement();

            if (null != attrName && attrName.startsWith(reqPrefix)) {

                paraName = attrName.substring(attrName.indexOf(reqPrefix) + reqPrefix.length(),
                        attrName.length());

                reqAttr = request.getAttribute(attrName);
                String attrVal = "";
                if (null != reqAttr) {
                    attrVal = reqAttr.toString();
                }
                param.put(paraName, attrVal);
            }
        }
        return param;

    }

    /**
     * 替换掉字符串开头的域名字符串
     *
     * @param val url value
     * @return 去除域名的路径
     */
    public static String replaceDomain(final String val) {
        String result = val;

        if (StringUtils.isBlank(result)) {
            return "";
        }

        int pos = -1;

        result = result.toLowerCase();

        if (result.startsWith(AppConstant.HTTP_DEFAULT_SCHEME)
                || result.startsWith(AppConstant.HTTPS_DEFAULT_SCHEME)) {
            pos = result.indexOf("/", 8);
            if (pos > -1) {
                result = result.substring(pos);
            }

        }

        return result;
    }

}
