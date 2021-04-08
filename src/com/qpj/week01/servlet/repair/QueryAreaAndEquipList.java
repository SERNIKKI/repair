package com.qpj.week01.servlet.repair;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.dao.RepairDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryAreaAndEquipList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        RepairDao repairDao = new RepairDao();
        List<String> building = null;
        List<String> equType = null;
        try {
            building = repairDao.selectBuilding();
            equType = repairDao.selectEquType();
            repairDao.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        if(building!=null){
            jsonObject.put("message","查询成功");
            jsonObject.put("area",building);
        }else {
            jsonObject.put("message","查询失败");
            jsonObject.put("area",null);
        }
        if(equType!=null){
            jsonObject.put("message","查询成功");
            jsonObject.put("equip",equType);
        }else {
            jsonObject.put("message","查询失败");
            jsonObject.put("equip",null);
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString = jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
    }
}
