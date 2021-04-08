package com.qpj.week01.servlet.android;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qpj.week01.been.JsonData;
import com.qpj.week01.dao.RepairDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaintenanceAreaAndEquipQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String token = req.getHeader("token");
        String mobile = req.getHeader("mobile");
        JsonData<Map<String, List<String>>> jsonData = new JsonData<>();
        if(token!=null){
            if(token.equalsIgnoreCase(req.getSession().getId())){
                //token有效
                RepairDao repairDao = new RepairDao();
                List<String> building = null;
                List<String> equType = null;
                try {
                    building = repairDao.selectBuilding();
                    equType = repairDao.selectEquType();
                    Map<String,List<String>> map = new HashMap<>();
                    map.put("building",building);
                    map.put("equType",equType);
                    jsonData.setCode(0);
                    jsonData.setMsg("成功");
                    jsonData.setData(map);
                    repairDao.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }else {
            jsonData.setCode(-1);
            jsonData.setMsg("token失效");
        }
        String result = JSON.toJSONString(jsonData, SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(result);
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
