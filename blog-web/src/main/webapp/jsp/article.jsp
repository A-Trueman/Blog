<%--
  Created by IntelliJ IDEA.
  User: Lincg
  Date: 2017/5/28
  Time: 21:57
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
    <link rel="stylesheet" href="../editor/css/editormd.preview.min.css">
    <style>
        .editormd-html-preview {
            width: 100%;
            margin: 0 auto;
        }

    </style>
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
</div>
<div class="container minHeight">
    <div class="row content">
        <div class="col-sm-12 blog-main">
            <h1 class="blog-title">${article.title}</h1>
            <p class="lead blog-description">${article.createTime} by <a href="${article.usernameUrl}">${article.username}</a></p>

            <div id="test-editormd-view">
                <textarea id="append-test" style="display:none;"><c:if test="${not empty initData}">${initData}</c:if></textarea>
            </div>
            <div class="bottom-bar row">
                <hr>
                <div class="col-sm-4">
                    <label>标签：</label><code>${article.tag}</code>
                </div>
                <div class="col-sm-2 col-sm-offset-6">
                    <c:choose>
                        <c:when test="${isCollected}">
                            <i class="iconfont collect right active"></i><label class="right">收藏：</label>
                        </c:when>
                        <c:otherwise>
                            <i class="iconfont collect right"></i><label class="right">收藏：</label>
                        </c:otherwise>
                    </c:choose>
                </div>
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
<script src="../editor/lib/marked.min.js"></script>
<script src="../editor/lib/prettify.min.js"></script>
<script src="../editor/lib/raphael.min.js"></script>
<script src="../editor/lib/underscore.min.js"></script>
<script src="../editor/lib/sequence-diagram.min.js"></script>
<script src="../editor/lib/flowchart.min.js"></script>
<script src="../editor/lib/jquery.flowchart.min.js"></script>
<script src="../editor/editormd.min.js"></script>
<script src="../dist/js/user.js"></script>
<script>



    $(function() {
        var testEditormdView;

        testEditormdView = editormd.markdownToHTML("test-editormd-view", {
            htmlDecode      : "style,script,iframe",  // you can filter tags decode
            emoji           : true,
            taskList        : true,
            tex             : true,  // 默认不解析
            flowChart       : true,  // 默认不解析
            sequenceDiagram : true   // 默认不解析
        });
    });

    $('.collect').click(function() {
        var data = new Object();
        var id = "<c:out value='${article.id}' />";
        data.articleId = id;
        var json = JSON.stringify(data);
        if ($('.collect').hasClass('active')) {
            if ($(".blog-nav a:last-child").text() == "未登录") {
                swal({
                    title: "请先登录账号！",
                    type: "error",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else {
                $.ajax({
                    type: 'post',
                    contentType: 'application/json',
                    url: '/like/cancelCollect.html',
                    data: json,
                    success: function (result) {
                        if (result == "1") {
                            swal({
                                title: "取消收藏成功！",
                                type: "success",
                                timer: 3000,
                                showConfirmButton: true
                            });
                            $('.collect').removeClass('active');
                        } else {
                            swal({
                                title: "取消收藏失败！",
                                type: "error",
                                timer: 3000,
                                showConfirmButton: true
                            });
                        }

                    },
                    error: function () {
                        swal({
                            title: "取消收藏失败！",
                            type: "error",
                            timer: 3000,
                            showConfirmButton: true
                        });
                    }
                })
            }
        } else {

            if ($(".blog-nav a:last-child").text() == "未登录") {
                swal({
                    title: "请先登录账号！",
                    type: "error",
                    timer: 3000,
                    showConfirmButton: true
                });
            } else {

                $.ajax({
                    type: 'post',
                    url: '/like/collect.html',
                    contentType: 'application/json',
                    dataType: "json",
                    data: json,
                    success: function (result) {
                        if (result == "1") {
                            swal({
                                title: "收藏成功！",
                                type: "success",
                                timer: 3000,
                                showConfirmButton: true
                            });
                            $('.collect').addClass('active');
                        } else {
                            swal({
                                title: "收藏失败！",
                                type: "error",
                                timer: 3000,
                                showConfirmButton: true
                            });
                        }

                    },
                    error: function () {
                        swal({
                            title: "收藏失败！",
                            type: "error",
                            timer: 3000,
                            showConfirmButton: true
                        });
                    }
                })
            }
        }
    });

</script>
</body>
</html>

