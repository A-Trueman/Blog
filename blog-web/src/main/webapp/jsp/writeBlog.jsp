<%--
  Created by IntelliJ IDEA.
  User: Lincg
  Date: 2017/5/19
  Time: 1:41
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
    <link href="../dist/css/sweetalert.css" rel="stylesheet">
    <link rel="stylesheet" href="../editor/css/editormd.css" />
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="form blog-form">
        <form method="post" id="blogForm">
            <div class="write-blog-status">
                <label for="status">权限：</label>
                <select id="status" name="status">
                    <option value="1">公开</option>
                    <option value="2">私密</option>
                </select>
            </div>
            <div class="write-blog-tag">
                <label for="tag">标签：</label>
                <input type="text" id="tag" name="tag" >
            </div>
            <div class="write-blog-title">
                <label for="title">标题：</label>
                <input type="text" id="title" name="title" required >
            </div>

            <div class="editormd" id="editormd">
                <textarea class="editormd-markdown-textarea" name="editormd-markdown-doc"></textarea>
            </div>
        </form>
    </div>
    <div>
        <a href="#" class="button red">发表</a>
        <a href="#" class="button white">取消</a>
    </div>

</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../dist/js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../dist/js/bootstrap.min.js"></script>
<script src="../dist/js/sweetalert.min.js"></script>
<script src="../editor/editormd.min.js"></script>
<script>
    var testEditor;

    $(function() {
        testEditor = editormd("editormd", {
            width   : "100%",
            height  : 640,
            syncScrolling : "single",
            path    : "../editor/lib/",
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "../img",
            saveHTMLToTextarea : true
        });

        var test = $("#publish");
        console.log(test.text());
        var test2 = $(".button.red");
        console.log(test2.text());
        /*
         // or
         testEditor = editormd({
         id      : "test-editormd",
         width   : "90%",
         height  : 640,
         path    : "../lib/"
         });
         */
    });




    $(".button.red").click(function() {
        var jsonData = JSON.stringify($("#blogForm").serializeObject());
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/writeBlog.html',
            data: jsonData,
            success: function () {
                swal({
                    title: "保存成功！",
                    type: "success",
                    timer: 3000,
                    showConfirmButton: true
                },
                    function () {
                        window.location.href = "/myBlogList.html";
                    });
            },
            error: function () {
                swal({
                    title: "保存失败！",
                    type: "error",
                    timer: 3000,
                    showConfirmButton: true
                });
            }

        })
    });

    $(".button.white").click(function () {
        swal({
            title: "确定取消吗？",
            text: "你的文章将不被保存！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定取消！",
            closeOnConfirm: false
        },
            function () {
                window.location.href = "/myBlogList.html";
            });
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
    window.onload = function(){
        var height = "900" + 'px';
        var iframe = parent.document.getElementById('myBlog');
        iframe.style.height = height;
    };
</script>
</body>
</html>
