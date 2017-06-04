<%--
  Created by IntelliJ IDEA.
  User: Lincg
  Date: 2017/5/19
  Time: 1:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="icon" href="../img/favicon.ico">

    <title>New World</title>

    <!-- Bootstrap -->
    <link href="../dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../dist/css/common.css" rel="stylesheet">
    <link href="../dist/css/user_form.css" rel="stylesheet">
    <!-- Blog.css -->
    <link href="../dist/css/blog.css" rel="stylesheet">
    <link href="../dist/css/sweetalert.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <!--
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    -->
    <![endif]-->
</head>
<body>
<div class="blog-header">
    <img src="../img/header/logo.png" class="left blog-logo">
    <div class="container">
        <form class="search-form-wrapper" action="/search.html" method="post">
            <button type="submit" class="btn btn-default">Search</button>
            <input type="text" name="searchCond" class="form-control" placeholder="Search" required>
        </form>
    </div>
</div>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item" href="/index.html">首页</a>
            <a class="blog-nav-item" href="/attention.html">关注</a>
            <a class="blog-nav-item" href="/allSite.html">全站</a>
            <a class="blog-nav-item" href="/like.html">收藏</a>
            <a class="blog-nav-item active" href="myBlog.html">我的博客</a>
            <c:choose>
                <c:when test="${not empty username}">
                    <li class="dropdown blog-nav-item right">
                        <a class="dropdown-toggle" data-toggle="dropdown">${username}</a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">设置</a>
                            </li>
                            <li>
                                <a href="/user/logout.html">注销</a>
                            </li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <a class="blog-nav-item right" href="#loginModal" data-toggle="modal" >未登录</a>
                </c:otherwise>
            </c:choose>
        </nav>
    </div>
</div>


<iframe src="/myBlogList.html" scrolling="no" name="myBlog" allowtransparency="yes" id = "myBlog" frameborder="no" width="100%"></iframe>
<footer class="blog-footer">
    <pre>Copyright © 2016-2017 By Lin</pre>
    <pre><a href="http://www.miitbeian.gov.cn/">浙ICP备17021798</a></pre>
</footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../dist/js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../dist/js/bootstrap.min.js"></script>
<script src="../dist/js/sweetalert.min.js"></script>
</body>
</html>
