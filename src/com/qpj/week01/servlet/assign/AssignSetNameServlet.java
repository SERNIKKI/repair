package com.qpj.week01.servlet.assign;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.RepairInfoVo;
import com.qpj.week01.been.UserInfo;
import com.qpj.week01.dao.AssignDao;
import com.qpj.week01.dao.MaintainDao;
import com.qpj.week01.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AssignSetNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id = req.getParameter("id");
        String maintainName = req.getParameter("maintainName");
        System.out.println(maintainName);

        JSONObject jsonObject = new JSONObject();
        AssignDao assignDao = new AssignDao();
        UserDao userDao = new UserDao();
        try {
            RepairInfoVo repairInfoVo = new RepairInfoVo();
            repairInfoVo.setId(Integer.parseInt(id));
            repairInfoVo.setStatus(1);
            repairInfoVo.setMaintenanceUserID(userDao.selectByName(maintainName).getId());
            if (assignDao.update(repairInfoVo)) {
                jsonObject.put("message", "成功");
                jsonObject.put("status", "success");
            } else {
                jsonObject.put("message", "失败");
                jsonObject.put("status", "fail");
            }
            assignDao.conn.close();
            userDao.conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        resp.setContentType("application/json;charset=utf-8");
        String jsonString = jsonObject.toJSONString();
        resp.getWriter().println(jsonString);
    }
}
