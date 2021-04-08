<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/1
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
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
<%--    <h1>登陆成功，欢迎<span><%=request.getAttribute("username")%></span></h1>--%>
    <h1>登陆成功，欢迎</h1>
    <center><p>5秒钟后系统会自动跳转</p></center>
    <%response.setHeader("refresh","5;url=findAllServlet");%>
</body>
</html>
