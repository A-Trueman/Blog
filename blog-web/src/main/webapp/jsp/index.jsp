<%--
  Created by IntelliJ IDEA.
  User: Lincg
  Date: 2017/5/14
  Time: 1:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a class="blog-nav-item active" href="#">首页</a>
            <a class="blog-nav-item" href="#">关注</a>
            <a class="blog-nav-item" href="#">全站</a>
            <a class="blog-nav-item" href="#">收藏</a>
            <a class="blog-nav-item" href="#">我的博客</a>
            <a class="blog-nav-item right" href="#loginModal" data-toggle="modal" >未登录</a>
        </nav>
    </div>
</div>

<div class="container">
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
        <div class="form-container transition">
            <div class="form info-form clearFix">

                <form action="" method="post">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h2 id="loginModalLabel">
                        OPEN YOUR BLOG
                    </h2>
                    <input type="text" name="user.username" value="username" required onfocus="$(this).attr('type','text');$(this).val('')">
                    <input type="text" name="user.password" value="password" required onfocus="$(this).attr('type','password');$(this).val('')">
                    <input type="submit" class="transition hover-scale" value="Login">
                </form>

                <form action="" method="post">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h2>CREATE YOUR BLOG</h2>
                    <input type="text" name="user.username" value="username" maxlength="12" pattern="\w{3,}" required onfocus="$(this).attr('type','text');$(this).val('')">
                    <input type="text" name="user.password" id="password" value="password" maxlength="12" pattern="\w{6,}" required onfocus="$(this).attr('type','password');$(this).val('')">
                    <input type="text" value="repeat password" maxlength="12" onblur="checkPassword($('#password'),$(this))" required onfocus="$(this).attr('type','password');$(this).val('')">
                    <input type="email" name="user.email" value="email" required onfocus="$(this).val('')">
                    <input type="text" name="user.phone" value="mobile" required onfocus="$(this).attr('type','text');$(this).val('')">
                    <table style="width: 50%">
                        <tr>
                            <td><label>man</label><input type="radio" name="user.sex" value="0" required></td>
                            <td><label>woman</label><input type="radio" name="user.sex" value="1" required></td>
                        </tr>
                    </table>
                    <input type="submit" class="transition hover-scale" style="margin-top: 20px" value="Submit">
                </form>

                <span class="form-change changed">Register</span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8 blog-main">
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

<script>

    $(function(){
        /**
         $('#loginModal').on('show.bs.modal', function(){
            $(this).find('.close').css({'margin-left' : '-50%'});
        })*/
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
