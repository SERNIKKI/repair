package com.qpj.week01.servlet.role;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.dao.RepairDao;
import com.qpj.week01.dao.RoleDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoleNameList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        RoleDao roleDao = new RoleDao();
        List<String> roleName = null;
        try {
            roleName = roleDao.selectAllName();
            roleDao.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        if(roleName!=null){
            jsonObject.put("message","查询成功");
            jsonObject.put("rolename",roleName);
        }else {
            jsonObject.put("message","查询失败");
            jsonObject.put("rolename",null);
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString = jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
    }
}
