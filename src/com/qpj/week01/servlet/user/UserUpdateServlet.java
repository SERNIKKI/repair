package com.qpj.week01.servlet.user;

import com.alibaba.fastjson.JSONObject;
import com.qpj.week01.been.UserInfo;
import com.qpj.week01.dao.RoleDao;
import com.qpj.week01.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String id=req.getParameter("id");
        String username=req.getParameter("user_name");
        String password=req.getParameter("user_password");
        String rolename=req.getParameter("role_name");
        int roleid= 0;
        try {
            RoleDao roleDao = new RoleDao();
            UserDao userDao = new UserDao();
            roleid = roleDao.selectID(rolename);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(Integer.parseInt(id));
            userInfo.setUser_name(username);
            userInfo.setUser_password(password);
            userInfo.setRoleID(roleid);
            JSONObject jsonObject = new JSONObject();
            boolean update = userDao.update(userInfo);
            if(update){
                jsonObject.put("message","操作成功");
                jsonObject.put("status","success");
            }else {
                jsonObject.put("message","操作失败");
                jsonObject.put("status","fail");
            }
            roleDao.conn.close();
            userDao.conn.close();
            resp.setContentType("application/json;charset=utf-8");
            String jsonString=jsonObject.toJSONString();
            resp.getWriter().println(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
