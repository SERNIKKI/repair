package com.qpj.week01.servlet.android;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qpj.week01.been.JsonData;
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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class MaintenanceQueryByUserIdServlet extends HttpServlet {
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
        JsonData<List<RepairInfoVo>> jsonData = new JsonData<>();
        List<RepairInfoVo> repairInfoVos = null;
        UserDao userDao = new UserDao();
//        UserInfo userInfo = (UserInfo)req.getSession().getAttribute("_m_userInfo");
//        token = userInfo.getToken();
        if(token!=null){
            if(token.equalsIgnoreCase(req.getSession().getId())){
                //在token有效期内
                UserInfo userInfo = (UserInfo)req.getSession().getAttribute("_m_userInfo");
                int id = userInfo.getId();
                //根据报修人id查询报修信息
                MaintainDao maintainDao  = new MaintainDao();
                try {
                    repairInfoVos = maintainDao.selectByID(id);
                    for (RepairInfoVo repairInfoVo : repairInfoVos) {
                        if(repairInfoVo.getMaintenanceUserID()>0) {
                            repairInfoVo.setMaintenanceUserName(userDao.selectById(repairInfoVo.getMaintenanceUserID()));
                        }
                    }
                    jsonData.setCode(0);
                    jsonData.setMsg("成功");
                    jsonData.setData(repairInfoVos);

                    userDao.conn.close();
                    maintainDao.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }else {
            jsonData.setCode(-1);
            jsonData.setMsg("token失效");
        }
        String result = JSON.toJSONString(jsonData, SerializerFeature.WriteNullListAsEmpty);
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
