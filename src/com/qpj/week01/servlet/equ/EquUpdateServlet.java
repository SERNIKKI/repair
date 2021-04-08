package com.qpj.week01.servlet.equ;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.EquInfo;
import com.qpj.week01.dao.EquDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EquUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id = req.getParameter("id");
        String equ_name = req.getParameter("equ_name");
        String equ_style = req.getParameter("equ_style");
        String responsible = req.getParameter("responsible");
        String remark = req.getParameter("remark");
        System.out.println("id = " + id);
        EquDao equDao = new EquDao();
        boolean insert = false;
        try {
            insert = equDao.update(new EquInfo(Integer.parseInt(id),equDao.maxID(),equ_name,equ_style,responsible,remark,""));
            equDao.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        if(insert){//成功
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
