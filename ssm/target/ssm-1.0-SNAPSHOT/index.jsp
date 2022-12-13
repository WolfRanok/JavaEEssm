<%--
  User: Sharm
  Date: 2021/11/12
  Email:share_me@126.com
--%>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }
        h3{
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<h3>
    <%-- 配置了 Tomcat 服务器后就会自动补全了 --%>
    <a href="${pageContext.request.contextPath}/loginTo">进入登录界面</a>
</h3>
</body>
</html>

<%-- 重定向到用户登录页面 --%>
<%--<% response.sendRedirect("goLogin"); %>--%>
