package com.qpj.week01.servlet.maintain;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.RepairInfoVo;
import com.qpj.week01.been.UserInfo;
import com.qpj.week01.dao.MaintainDao;
import com.qpj.week01.dao.RepairDao;
import com.qpj.week01.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MaintainFinishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id = req.getParameter("id");
        String status = req.getParameter("mainStatus");
        String mainContent = req.getParameter("mainContent");

        JSONObject jsonObject = new JSONObject();
        MaintainDao maintainDao = new MaintainDao();
        try {
            RepairInfoVo repairInfoVo = new RepairInfoVo();
            repairInfoVo.setId(Integer.parseInt(id));
            repairInfoVo.setStatus(Integer.parseInt(status));
            repairInfoVo.setMaintenanceContent(mainContent);
            if (maintainDao.update(repairInfoVo)) {
                jsonObject.put("message", "成功");
                jsonObject.put("status", "success");
            } else {
                jsonObject.put("message", "失败");
                jsonObject.put("status", "fail");
            }
            maintainDao.conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString = jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
    }
}
