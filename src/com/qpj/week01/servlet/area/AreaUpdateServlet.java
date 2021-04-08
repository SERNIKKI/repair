package com.qpj.week01.servlet.area;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.AreaInfo;
import com.qpj.week01.dao.AreaDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AreaUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id = req.getParameter("id");
        String building = req.getParameter("building");
        String floor = req.getParameter("floor");
        AreaDao areaDao = new AreaDao();
        boolean update = false;
        try {
            update = areaDao.update(new AreaInfo(Integer.parseInt(id),building,floor));
            areaDao.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        if(update){//成功
            //{"message":"修改成功","status":"success"}
            jsonObject.put("message","修改成功");
            jsonObject.put("status","success");
        }else {//失败
            //{"message":"修改失败","status":"fail"}
            jsonObject.put("message","修改失败");
            jsonObject.put("status","fail");
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString = jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
    }
}
