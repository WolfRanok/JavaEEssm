<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/updateBook" method="post">
        <%-- 只有在表单提交时在隐藏域中增加 bookId 信息，保存到数据库的时候才不会出错 --%>
        <%-- 不能使用 ${book.bookId()} 来获得数据，因为 bookId 是私有变量  --%>
        <input type="hidden" name="id" value="${book.getId()}"/>
        书籍名称：<input type="text" name="name" value="${book.getName()}"/>
        书籍出版社：<input type="text" name="press" value="${book.getPress()}"/>
        书籍作者：<input type="text" name="author" value="${book.getAuthor() }"/>
        书籍价格：<input type="text" name="bookPrice" value="${book.getBookPrice() }"/>
        <input type="submit" value="提交"/>
    </form>

</div>