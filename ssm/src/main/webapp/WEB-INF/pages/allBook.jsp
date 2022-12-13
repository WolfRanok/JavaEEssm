<%--
  User: Sharm
  Date: 2021/11/13
  Email:share_me@126.com
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap 框架的 cdn -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- 页面顶部 -->
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体,'Lucida Console',serif">
        <span style="float:right; padding-right:20px;" class="head">
            <%-- 从Session中获取登录用户的用户名	--%>
        	<span style="color:red; font-weight:bold;">${userInfo.username}</span>&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="loginOut" id="loginOut" style="color: darkgrey;" class="easyui-linkbutton"
               data-options="iconCls:'icon-exit',plain:true">
                [安全退出]
        	</a>
        </span>
    <span style="padding-left:10px; font-size: 20px; color:darkgrey;font-weight: bold">学生管理系统 — SSM</span>
</div>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 —— 显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/toAddBook">新增书籍</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/allBook">显示全部书籍</a>
        </div>

        <div class="col-md-8 column">
            <form class="form-inline" action="${pageContext.request.contextPath}/queryBookByName" method =
                    "post" style="float:right">
                <%-- span 标签就是用来接收传回前端的错误信息 --%>
                <span style="color:red;font-weight: bold">${error}</span>
                <input type="text" name="name" class="form-control" placeholder="请输入要查询的书籍的名称">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍出版社</th>
                    <th>书籍作者</th>
                    <th>书本价格</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <%-- requestScope 是 EL 表达式获取到的 request 域中的数据 --%>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <%-- setter 方法要和实体类中的 setter 方法一致 --%>
                        <td>${book.getId()}</td>
                        <td>${book.getName()}</td>
                        <td>${book.getPress()}</td>
                        <td>${book.getAuthor()}</td>
                        <td>${book.getBookPrice()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/toUpdateBook?id=${book.getId()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/deleteBook?id=${book.getId()}">删除</a>
<%--                            <a href="#">更改</a> |--%>
<%--                            <a href="#">删除</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- 页面底部-->
    <div region="south" split="true" style="height: 30px;">
        <div class="footer" style='background: #148cf1;position:absolute;bottom:0px'>
            Copyright @ 2022 智能20级. All rights reserved |
        </div>
    </div>
</div>
