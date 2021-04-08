package com.qpj.week01.servlet;

import com.qpj.week01.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String pw = request.getParameter("password");
//        if(pw.equals("")){
//            request.getRequestDispatcher("error.jsp").forward(request,response);
//        }else {
//            System.out.println(name + " " + pw);
//        }
        request.setAttribute("username",name);
        try {
            String sql = "select * from user where user_name = ? and user_password = ?";
            PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pw);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
            ps.close();
            rs.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
