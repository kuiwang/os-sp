<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = new StringBuffer(request.getScheme()).append("://").append(request.getServerName()).append(":").append(request.getServerPort()).append(path).toString();

//fixed for web app deploy to root server context
//如果应用部署的站点根目录，则 path 值为空，导致部分URL跳转失效
if(null== path || "".equals(path)){
    path = basePath;
}
request.setAttribute("app.path",path);
request.setAttribute("app.base",basePath);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>common page</title>
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/common/error/style.css?t=${commonAppTimestamp}" />
<script type="text/javascript"
    src="${pageContext.request.contextPath}/static/js/angular/angular-1.5.8.min.js?t=${commonAppTimestamp}"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/static/js/jquery/jquery-3.2.1.min.js?t=${commonAppTimestamp}"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/static/js/react/react-15.1.0.js?t=${commonAppTimestamp}"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/static/js/require/require-2.3.3.min.js?t=${commonAppTimestamp}"></script>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/static/js/seajs/sea-2.2.3.js?t=${commonAppTimestamp}"></script>
<script type="text/javascript">
<!--//-->//><!--
var app = {};
app.path    = '<%=path%>';
app.base    = '<%=basePath%>';
app.success = '1';
app.failed = '0';

    function app_title(title) {
        document.title = title + ' - ' + document.title;
    }
    function app_alert(msg, callback) {
        alert(msg);
    }
    function app_confirm(msg, callback) {
        return confirm(msg);
    }
    function app_prompt(title, default_value, callback) {
        return window.prompt(title, default_value);
    }
    function app_url_encode(msg, callback) {
        return encodeURIComponent(msg);
    }
    function app_log(msg) {
        console.log(msg);
    }
    //--><!
</script>