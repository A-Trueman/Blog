<%--
  Created by IntelliJ IDEA.
  User: Lincg
  Date: 2017/5/19
  Time: 1:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    boolean isLogin = false;
    String loginName = (String)session.getAttribute("username");
    if (loginName != null && !"".equals(loginName)) {
        isLogin = true;
    }
    request.setAttribute("isLogin", isLogin);
    request.setAttribute("loginName", loginName);
%>
<html lang="zh-CN">
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
<div class="container">
    <div class="mod-tab">
        <div class="mod-tab-list">
            <ul>
                <li class="selected"><a href="#">我的文章</a></li><!--
                 --><li><a href="#">私密文章</a></li>
            </ul>
        </div>
    </div>

    <div class="row content">
        <div class="col-sm-8 blog-main">
            <div class="blog-button">
                <a href="/writeBlog.html" class="button-text">写日志</a>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
            <div class="blog-post">
                <a class="blog-post-title">Sample blog post</a>
                <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
                <hr>
            </div>
        </div>

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <div class="sidebar-module">
                <h4>分类标签</h4>
                <ol class="list-unstyled">
                    <li><a href="#">JAVA</a></li>
                    <li><a href="#">C++</a></li>
                    <li><a href="#">JAVASCRIPT</a></li>
                    <li><a href="#">C#</a></li>
                    <li><a href="#">随笔</a></li>
                    <li><a href="#">前端</a></li>
                    <li><a href="#">手机开发</a></li>
                    <li><a href="#">数据库</a></li>
                    <li><a href="#">其他</a></li>
                </ol>
            </div>

            <div class="sidebar-module">
                <h4>Elsewhere</h4>
                <ol class="list-unstyled">
                    <li><a href="#">GitHub</a></li>
                    <li><a href="#">Twitter</a></li>
                    <li><a href="#">Facebook</a></li>
                </ol>
            </div>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../dist/js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../dist/js/bootstrap.min.js"></script>
<script src="../dist/js/sweetalert.min.js"></script>
<script>
    window.onload = function(){
        var height = $(document).height() + 'px';
        var iframe = parent.document.getElementById('myBlog');
        iframe.style.height = height;
    }
</script>
</body>
</html>
