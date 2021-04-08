package com.qpj.week01.servlet.assign;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.UserInfo;
import com.qpj.week01.dao.RepairDao;
import com.qpj.week01.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class QueryMaintainName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        UserDao userDao = new UserDao();
        List<UserInfo> userInfos = null;
        try {
            userInfos = userDao.selectAll();
            userDao.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        if(userInfos!=null){
            jsonObject.put("message","获取列表成功");
            jsonObject.put("user_name",userInfos);
        }else {
            jsonObject.put("message","获取列表失败");
            jsonObject.put("user_name",null);
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString = jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
    }
}
