package com.qpj.week01.servlet.android;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qpj.week01.been.EquInfo;
import com.qpj.week01.been.JsonData;
import com.qpj.week01.dao.RepairDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class MEquipmentQueryByTypeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
//        super.doPost(req, resp);
        String token = req.getHeader("token");
        String mobile = req.getHeader("mobile");
        String equipmentType = req.getParameter("equipmentType");
        equipmentType = new String(equipmentType.getBytes("ISO-8859-1"),"UTF-8");

        JsonData<List<EquInfo>> jsonData = new JsonData<>();
        if(token!=null){
            if(token.equalsIgnoreCase(req.getSession().getId())){
                RepairDao repairDao = new RepairDao();
                if(equipmentType!=null&&!equipmentType.isEmpty()){
                    try {
                        List<EquInfo> equInfos = repairDao.selectEquName(equipmentType);

                        jsonData.setCode(0);
                        jsonData.setMsg("成功");
                        jsonData.setData(equInfos);
                        //关闭conn
                        repairDao.conn.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        }else {
            jsonData.setCode(-1);
            jsonData.setMsg("token失效");
        }
        // List转json
        String result = JSON.toJSONString(jsonData, SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(result);
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
