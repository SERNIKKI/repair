package com.qpj.week01.servlet.user;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id=req.getParameter("id");
        JSONObject jsonObject=new JSONObject();
        if(id!=null){
            try {
                UserDao userDao = new UserDao();
                boolean delete=userDao.delete(Integer.parseInt(id));
                if(delete){
                    jsonObject.put("message","删除成功");
                    jsonObject.put("status","success");
                }else {
                    jsonObject.put("message","删除失败");
                    jsonObject.put("status","fail");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString=jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
    }
}
