package com.qpj.week01.servlet.repair;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.EquInfo;
import com.qpj.week01.dao.RepairDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryByEquipType extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String equType = req.getParameter("equipmentType");
        List<EquInfo> equInfos = null;
        RepairDao repairDao = new RepairDao();
        try {
            equInfos = repairDao.selectEquName(equType);
            repairDao.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("equipName", equInfos);
        resp.setContentType("application/json;charset=utf-8");
        String jsonString = jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
    }
}
