<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/11
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
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
