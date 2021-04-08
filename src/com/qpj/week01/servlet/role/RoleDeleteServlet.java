package com.qpj.week01.servlet.role;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.dao.RoleDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RoleDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id=req.getParameter("id");
        JSONObject jsonObject=new JSONObject();
        RoleDao roleDao = new RoleDao();
        if(id!=null){
            try {
                boolean delete=roleDao.delete(Integer.parseInt(id));
                if(delete){
                    jsonObject.put("message","删除成功");
                    jsonObject.put("status","success");
                }else {
                    jsonObject.put("message","删除失败");
                    jsonObject.put("status","fail");
                }
                roleDao.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString=jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
