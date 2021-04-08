package com.qpj.week01.servlet.role;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.RoleInfo;
import com.qpj.week01.dao.RoleDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RoleAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String rolename=req.getParameter("role_name");
        RoleDao roleDao = new RoleDao();
        boolean insert = roleDao.add(new RoleInfo(rolename));
        JSONObject jsonObject = new JSONObject();
        if(insert){
            jsonObject.put("message","添加成功");
            jsonObject.put("status","success");
        }else {
            jsonObject.put("message","添加失败");
            jsonObject.put("status","fail");
        }
        try {
            roleDao.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString=jsonObject.toJSONString();
//        System.out.println(jsonString);
        resp.getWriter().println(jsonString);
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
