package com.qpj.week01.servlet;

import com.qpj.week01.been.Rhesis;
import com.qpj.week01.dao.RhesisDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class FindAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RhesisDao rhesisDao = new RhesisDao();
        RhesisDao rhesisDao = new RhesisDao();
        List<Rhesis> list = rhesisDao.selectAll();
        request.setAttribute("list",list);
        @SuppressWarnings("unchecked")
        List<Rhesis> lists = (List<Rhesis>)request.getAttribute("list");
        //跳转到显示页面
        request.getRequestDispatcher("success.jsp").forward(request,response);
    }
}
