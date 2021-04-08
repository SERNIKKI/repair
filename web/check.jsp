<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.qpj.week01.utils.DBUtils" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/2
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>验证</title>
    <script type="text/javascript">
        function same() {
            loginForm.action="success.jsp";
            loginForm.submit();
        }
        function different() {
            alert("请输入正确的验证码");
            location.href = "login.jsp"
        }
        function error() {
            alert("账号或密码错误")
            location.href = "login.jsp"
        }
    </script>
</head>
<body>
    <%
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select * from user where user_name = ? and user_password = ?";
        PreparedStatement ps = null;
        boolean res = false;
        try {
            ps = DBUtils.getConnection().prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            res = rs.next();
            System.out.println(res);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    %>
    <form id="loginForm" name="loginForm" method="post">
        <input type="hidden" id="username" name="username" value=<%=name%>>
        <input type="hidden" id="password" name="password" value=<%=password%>>
    </form>
    <%
        String rand = session.getAttribute("code").toString();
        String input = request.getParameter("code");
        if(rand.equals(input)){
            if(res){
                session.setAttribute("username",name);
                out.println("<script language='javascript'>same();</script>");
            }else {
                out.println("<script language='javascript'>error();</script>");
            }
        }else {
            out.print("<script language='javascript'>different();</script>");
        }
    %>
</body>
</html>
