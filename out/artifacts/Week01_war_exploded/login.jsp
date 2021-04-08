<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/1
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>week01</title>
    <script type="text/javascript">
        function refresh() {
            document.getElementById("image").src = "image.jsp" + new Date();
        }
    </script>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <style type="text/css">
        h1{
            margin: 90px auto;
            text-align: center;
        }
    </style>
<%--    <style type="text/css">--%>
<%--        body{--%>
<%--            background-image: url("https://cdn.jsdelivr.net/gh/sernikki/MyMp3/img/bg.jpg");--%>
<%--            background-size: cover;--%>
<%--        }--%>
<%--        h1{ /*标题居中*/--%>
<%--            margin: 90px auto;--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--        form{   /*表单居中*/--%>
<%--            width: 300px;--%>
<%--            height: 220px;--%>
<%--            margin: 100px auto;--%>
<%--        }--%>
<%--        .item{--%>
<%--            width: 180px;--%>
<%--            display: inline-block;--%>
<%--            /*text-align: right;*/--%>
<%--        }--%>
<%--        .itemV{--%>
<%--            width: 180px;--%>
<%--            display: inline-block;--%>
<%--            text-align: right;--%>
<%--        }--%>
<%--        #btn{   /*按钮居中*/--%>
<%--            margin-left: 35px;--%>

<%--        }--%>
<%--    </style>--%>
</head>
<body>
    <h1>一言</h1>
    <div id="login_frame">
            <p id="image_logo"></p>
    <form action="check.jsp" method="post" id="loginFrom" name="loginFrom">
<%--        <span class="item">用户名：</span>--%>
<%--        <span><input type="text" name="username"/></span><br><br>--%>
            <p><label class="label_input">用户名</label><input type="text" name="username" class="text_field"/></p>
            <p><label class="label_input">密码</label><input type="password" name="password" class="text_field"/></p>
            <p><label class="label_input">验证码</label><input type="text" name="code" maxlength="4" class="text_field"/></p>
<%--        <span class="item">密码：</span>--%>
<%--        <span><input type="password" name="password"/></span><br><br>--%>
<%--        <span class="item">验证码：</span>--%>
<%--        <span><input type="text" name="code" maxlength="4"/></span><br><br>--%>
        <img id="image" border="0" onclick="refresh()" src="image.jsp" title="点击更换图片">
        <div id="login_control">
            <input type="submit" id="btn_login" value="登陆">
            <a id="forget_pwd" href="">忘记密码？</a>
<%--            <input type="reset"  value="重置">--%>
        </div>
    </form>
<%--    </div>    --%>
</body>
</html>
