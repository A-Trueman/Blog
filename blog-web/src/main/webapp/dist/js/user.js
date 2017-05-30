/**
 * Created by Lincg on 2017/5/30.
 */

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
