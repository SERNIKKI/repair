<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/1
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="com.qpj.week01.been.Rhesis" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
<style>
    body{
        background-image: url("https://cdn.jsdelivr.net/gh/sernikki/MyMp3/img/bg.jpg");
        background-attachment: fixed;
        background-size: cover;
    }
    h1{
        margin: 50px auto;
        text-align: center;
    }
    table{
        width: 600px;
        margin: 50px auto;
        border-collapse: collapse;
        text-align: center;
    }
    table,th,td{border: 1px solid black}
    th{height: 50px}
</style>
</head>
<body>
    <h1>欢迎来到一言</h1>
    <table style="border: 1px">
        <tr>
            <th>作者</th>
            <th>出自</th>
            <th>一言</th>
            <th>入库时间</th>
            <th>ID</th>
        </tr>
        <% Object ob = request.getAttribute("list"); List<Rhesis> list = (List<Rhesis>)ob;for(Rhesis r : list){ %>
        <tr>
            <td><%=r.getRhesis_writer()%></td>
            <td><%=r.getRhesis_book()%></td>
            <td><%=r.getRhesis_sentence()%></td>
            <td><%=r.getInputtime()%></td>
            <td><%=r.getRhesis_id()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
