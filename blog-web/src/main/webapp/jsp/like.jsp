<%--
  Created by IntelliJ IDEA.
  User: Lincg
  Date: 2017/5/28
  Time: 18:03
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
            <a class="blog-nav-item active" href="/like.html">收藏</a>
            <a class="blog-nav-item" href="/myBlog.html">我的博客</a>
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

<div class="container">
    <c:if test="${empty username}">
        <!-- 模态框（Modal） -->
        <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
            <div class="form-container transition">
                <div class="form info-form clearFix">

                    <form id="loginForm">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h2 id="loginModalLabel">
                            OPEN YOUR BLOG
                        </h2>
                        <input type="text" name="username" value="username" required onfocus="$(this).attr('type','text');$(this).val('')">
                        <input type="text" name="password" value="password" required onfocus="$(this).attr('type','password');$(this).val('')">
                        <input type="button" id="loginButton"class="transition hover-scale" value="Login">
                    </form>

                    <form id="registerForm">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h2>CREATE YOUR BLOG</h2>
                        <input type="text" name="username" maxlength="12" pattern="\w{3,}" required onfocus="$(this).attr('type','text');$(this).val('')" placeholder="username">
                        <input type="password" name="password" id="password" maxlength="12" pattern="\w{6,}" required placeholder="password">
                        <input type="password" maxlength="12" onblur="checkPassword($('#password'),$(this))" required placeholder="repeat password">
                        <input type="email" name="email" required placeholder="email">
                        <input type="text" name="phone" required placeholder="mobile phone" pattern="\d{11}">
                        <table style="width: 50%">
                            <tr>
                                <td><label>man</label><input type="radio" name="sex" value="0" required></td>
                                <td><label>woman</label><input type="radio" name="sex" value="1" required></td>
                            </tr>
                        </table>
                        <input type="button" id="registerButton" class="transition hover-scale" style="margin-top: 20px" value="Submit">
                    </form>

                    <span class="form-change changed">Register</span>
                </div>
            </div>
        </div>
    </c:if>
    <div class="row minHeight">
        <div class="col-sm-8 blog-main">
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
                            <li><a href="/like.html?lessDateTime=${lessDateTime}&pageCount=${pageCount}&tag=${tag}">前一页</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li class="active"><a href="#">第${pageCount}页</a></li>
                    <c:choose>
                        <c:when test="${empty lastDateTime}">
                            <li class="disabled"><a href="#">后一页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/like.html?lastDateTime=${lastDateTime}&pageCount=${pageCount}&tag=${tag}">后一页</a></li>
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
                        <c:when test="${not empty tags}">
                            <c:forEach var="tag" items="${tags}">
                                <li><a href="/like.html?tag=${tag}">${tag}</a></li>
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
<footer class="blog-footer">
    <pre>Copyright © 2016-2017 By Lin</pre>
    <pre><a href="http://www.miitbeian.gov.cn/">浙ICP备17021798</a></pre>
</footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../dist/js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../dist/js/bootstrap.min.js"></script>
<script src="../dist/js/sweetalert.min.js"></script>
<script src="../dist/js/user.js"></script>
<script>
    $(function(){
        /**
         $('#loginModal').on('show.bs.modal', function(){
            $(this).find('.close').css({'margin-left' : '-50%'});
        })*/
    });

</script>
</body>
</html>
