<%--
  Created by IntelliJ IDEA.
  User: Lincg
  Date: 2017/5/14
  Time: 1:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
    <link href="../dist/css/user_form.css" rel="stylesheet">
    <!-- Blog.css -->
    <link href="../dist/css/blog.css" rel="stylesheet">

    <!-- 弹出框 -->
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
        <form class="search-form-wrapper">
            <button type="submit" class="btn btn-default">Search</button>
            <input type="text" class="form-control" placeholder="Search" required>
        </form>
    </div>

</div>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item active" href="/index.html">首页</a>
            <a class="blog-nav-item" href="/attention.html">关注</a>
            <a class="blog-nav-item" href="/allSite.html">全站</a>
            <a class="blog-nav-item" href="/like.html">收藏</a>
            <a class="blog-nav-item" href="/myBlog.html">我的博客</a>
            <c:if test="${username != null}">
                <li class="dropdown blog-nav-item right">
                    <a class="dropdown-toggle" data-toggle="dropdown">${username}</a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">设置</a>
                        </li>
                        <li>
                            <a href="#">注销</a>
                        </li>
                    </ul>
                </li>
            </c:if>

            <c:if test="${username == null}">
                <a class="blog-nav-item right" href="#loginModal" data-toggle="modal" >未登录</a>
            </c:if>
        </nav>
    </div>
</div>

<div class="container">
    <c:if test="${!isLogin}">
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

    <div class="row">
        <div class="col-sm-8 blog-main">
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
                    <li><a href="https://github.com">GitHub</a></li>
                    <li><a href="https://twitter.com/">Twitter</a></li>
                    <li><a href="https://www.facebook.com/">Facebook</a></li>
                </ol>
            </div>
        </div>
    </div>
</div>

<footer class="blog-footer">
    <p>Copyright © 2016-2017 By Lin</p>
    <p><a href="http://www.miitbeian.gov.cn/">浙ICP备17021798</a></p>
</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../dist/js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../dist/js/bootstrap.min.js"></script>
<script src="../dist/js/sweetalert.min.js"></script>

<script>

    $(".blog-nav a:not(:last-child)").click(function () {
        if($(".blog-nav a:last-child").text() == "未登录") {
            swal({
                title: "请先登录账号！",
                type: "error",
                timer: 3000,
                showConfirmButton: true
            });
            return false;
        } else {
            return true;
        }

    });
    $(function(){
        /**
         $('#loginModal').on('show.bs.modal', function(){
            $(this).find('.close').css({'margin-left' : '-50%'});
        })*/
    });
    $("#loginButton").click(function () {
        var jsonData = JSON.stringify($("#loginForm").serializeObject());
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/user/login.html',
            data: jsonData,
            success: function () {
                if (arguments.length > 1 && arguments[1] == 'success') {
                    window.location.reload();
                } else {
                    swal({
                        title: "登录失败",
                        type: "error",
                        timer: 2000,
                        showConfirmButton: true
                    });
                }

            }
        })
    });

    $("#registerButton").click(function () {
        var jsonData = JSON.stringify($("#registerForm").serializeObject()) ;
        $.ajax({
            type: 'POST',
            dataType: "json",
            contentType: 'application/json',
            url: '/user/register.html',
            data: jsonData,

            success: function (data) {
                if(data == 1) {

                    swal({
                        title: "注册成功",
                        type: "success",
                        timer: 3000,
                        showConfirmButton: true
                    });

                    $('#loginModal').modal('hide');
                    $(".form-change").trigger('click');
                } else if(data == 2) {
                    swal({
                        title: "用户名重复",
                        type: "error",
                        timer: 2000,
                        showConfirmButton: true
                    });
                } else {
                    swal({
                        title: "注册失败",
                        type: "error",
                        timer: 2000,
                        showConfirmButton: true
                    });
                }



            }
        })
    });

    $("input[type=radio]").click(function(){
        $("input[type=radio]").removeClass("checked").removeAttr("checked");
        $(this).toggleClass("checked").attr("checked","checked");
    });

    $(".form-change").click(function(){
        $(".form-container").toggleClass("changed");
        if($(this).text()=="Register"){
            $(this).text("Login");
        }else{
            $(this).text("Register");
        }
    });

    $.fn.serializeObject = function(){
        var o = {};
        var a = this.serializeArray();
        $.each(a, function(){
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            }
            else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

    function checkPassword(pwd,rpwd){
        if(pwd.val()!=rpwd.val()){
            alert("密码重新输入有误，请检查重试");
            rpwd.val(null);
            pwd.val(null);
        }
    }
</script>
</body>
</html>
