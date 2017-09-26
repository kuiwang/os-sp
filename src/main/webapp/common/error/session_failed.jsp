<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/head.jsp"%>
<script type="text/javascript">
<!--//-->//><!--
    $(function() {
        app_title('操作失败');

    });

    //--><!
</script>
</head>

<body>
    <div class="wrapper">
        <!--主内容区开始-->
        <div class="wrap_center">
            <div class="error_title">
                <h2>操作失败</h2>
            </div>

            <div class="error_detail">操作失败 ${failed_msg}</div>

            <div class="error_goback">
                <span class="btn ico goback"> <a
                    href="${pageContext.request.contextPath}/">返回首页</a>
                </span>
            </div>
        </div>
        <!--主内容区结束-->
    </div>
</body>
</html>
<%@ include file="/common/foot.jsp"%>
