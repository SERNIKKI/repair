<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/1
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>一言</title>
<style>
    body{
        background-image: url("https://cdn.jsdelivr.net/gh/sernikki/MyMp3/img/bg.jpg");
        background-size: cover;
    }
    h1{
        margin: 150px auto;
        text-align: center;
    }
    span{
        color: red;
        font-family: fantasy;
    }
</style>
</head>
<body>
<%--    <h1>登陆失败，<span><%=request.getAttribute("username")%></span>用户名或者密码错误！</h1>--%>
    <h1>登陆失败,用户名或者密码错误！</h1>
    <center><p>5秒钟后系统会自动跳转到登录页面...</p></center>

    <%response.setHeader("refresh","5;url=login.jsp");%>
</body>
</html>
