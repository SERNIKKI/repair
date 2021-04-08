package com.qpj.week01.servlet.repair;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.RepairInfoVo;
import com.qpj.week01.been.UserInfo;
import com.qpj.week01.dao.RepairDao;
import com.qpj.week01.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RepairUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username = req.getParameter("username");
        String maintenanceSN = req.getParameter("maintenanceSN");
        String building = req.getParameter("building");
        String areaID = req.getParameter("areaID");//需要转换为int
        String equipmentType = req.getParameter("equipmentType");
        String equipmentID = req.getParameter("equipmentID");//需要转换为int
        String location = req.getParameter("location");
        String image = req.getParameter("image");
        String reportContent = req.getParameter("reportContent");
        String id = req.getParameter("id");


        JSONObject jsonObject = new JSONObject();
        UserDao userDao = new UserDao();
        RepairDao repairDao = new RepairDao();
        int area_id = 0;
        int equ_id = 0;
        try {
            if (areaID.length() != 0 && equipmentID.length() != 0) {
                area_id = Integer.parseInt(areaID);
                equ_id = Integer.parseInt(equipmentID);
                if (repairDao.selectByEU(area_id, equ_id)) {
                    UserInfo userInfo = userDao.selectByName(username);
                    RepairInfoVo repairInfoVo = new RepairInfoVo();
                    repairInfoVo.setMaintenanceSN(maintenanceSN);
                    repairInfoVo.setAreaID(area_id);
                    repairInfoVo.setEquipmentID(equ_id);
                    repairInfoVo.setLocation(location);
                    repairInfoVo.setImageURL(image);
                    repairInfoVo.setReportContent(reportContent);
                    repairInfoVo.setId(Integer.parseInt(id));
                    repairInfoVo.setReportUserID(userInfo.getId());
                    System.out.println(repairInfoVo);
                    if(repairDao.update(repairInfoVo)){
                        jsonObject.put("message","修改成功");
                        jsonObject.put("status","success");
                    }else {
                        jsonObject.put("message","修改失败");
                        jsonObject.put("status","fail");
                    }
                }else {
                    jsonObject.put("message","错误！表中已有重复数据");
                    jsonObject.put("status","fail");
                }
            } else {
                jsonObject.put("message", "错误！id为空");
                jsonObject.put("status", "fail");
            }
            userDao.conn.close();
            repairDao.conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString = jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
    }
}
