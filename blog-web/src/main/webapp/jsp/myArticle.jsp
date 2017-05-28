<%--
  Created by IntelliJ IDEA.
  User: nuomifan
  Date: 2017/5/25
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

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
<div class="container minHeight">
    <div class="row content">
        <div class="col-sm-12 blog-main">
            <h1 class="blog-title">${article.title}</h1>
            <p class="lead blog-description">${article.createTime} by <a>${article.username}</a></p>
            <c:import url="${article.articleRealUrl}"/>
            <hr>
            <div class="bottom-bar row">
                <div class="col-sm-4">
                    <label>标签：</label><code>${article.tag}</code>
                </div>
                <div class="col-sm-2 col-sm-offset-4">
                    <a class="right" href="/writeBlog.html?id=${article.id}">编辑</a>
                </div>
                <div class="col-sm-2">
                    <i class="iconfont collect right"></i><label class="right">收藏：</label>
                </div>
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
    $('.collect').click(function() {
        if ($('.collect').hasClass('active')) {
            $('.collect').removeClass('active');

        } else {
            $('.collect').addClass('active');
        }
    });
    window.onload = function(){
        var height = $(document).height() + 'px';
        var iframe = parent.document.getElementById('myBlog');
        iframe.style.height = height;
    }
</script>
</body>
</html>
