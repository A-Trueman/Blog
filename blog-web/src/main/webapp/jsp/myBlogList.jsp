<%--
  Created by IntelliJ IDEA.
  User: Lincg
  Date: 2017/5/19
  Time: 1:40
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
<div class="container">
    <div class="mod-tab">
        <div class="mod-tab-list">
            <ul>
                <c:choose>
                    <c:when test="${empty status || status == 1}">
                        <li class="selected"><a href="myBlogList.html">我的文章</a></li><!--
                        --><li><a href="myBlogList.html?status=2">私密文章</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="myBlogList.html">我的文章</a></li><!--
                        --><li class="selected"><a href="myBlogList.html?status=2">私密文章</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>

    <div class="row content minHeight">
        <div class="col-sm-8 blog-main">
            <div class="blog-button">
                <a href="/writeBlog.html" class="button-text">写日志</a>
            </div>
            <c:forEach items="${articles}" var="article">
                <div class="blog-post">
                    <a class="blog-post-title" href= ${article.articleUrl}>${article.title}</a>
                    <p>${article.preArticle}</p>
                    <p class="blog-post-meta right">${article.createTime}&nbsp;&nbsp;by&nbsp;&nbsp;<a href= ${article.usernameUrl}>${article.username}</a>&nbsp;&nbsp; 阅读数量(${article.readCounts})</p>
                    <p class="clear"></p>
                    <hr>
                </div>
            </c:forEach>

            <ul class="pagination">
                <c:if test="${not empty lessDateTime || not empty lastDateTime}">
                    <c:choose>
                        <c:when test="${empty lessDateTime}">
                            <li class="disabled"><a href="#">前一页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/myBlogList.html?lessDateTime=${lessDateTime}&pageCount=${pageCount}&status=${status}&tag=${tag}">前一页</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li class="active"><a href="#">第${pageCount}页</a></li>
                    <c:choose>
                        <c:when test="${empty lastDateTime}">
                            <li class="disabled"><a href="#">后一页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/myBlogList.html?lastDateTime=${lastDateTime}&pageCount=${pageCount}&status=${status}&tag=${tag}">后一页</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </ul>
        </div>

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <div class="sidebar-module">
                <h4>分类标签</h4>
                <ol class="list-unstyled">
                    <c:choose>
                        <c:when test="${not empty tagVos}">
                            <c:forEach var="tag" items="${tagVos}">
                                <li><a href="/myBlogList.html?tag=${tag.tag}&status=${status}">${tag.tag}(${tag.count})</a></li>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <li>无</li>
                        </c:otherwise>
                    </c:choose>
                </ol>
            </div>

            <div class="sidebar-module">
                <h4>Elsewhere</h4>
                <ol class="list-unstyled">
                    <li><a href="https://github.com">GitHub</a></li>
                    <li><a href="https://twitter.com/">Twitter</a></li>
                    <li><a href="https://www.facebook.com/">Facebook</a></li>
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
