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
import java.sql.SQLException;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        String role_name = req.getParameter("role_name");
        try {
            RoleDao roleDao = new RoleDao();
            UserDao userDao = new UserDao();
            int roleId = roleDao.selectID(role_name);
            UserInfo user = new UserInfo();

            user.setUser_name(username);
            user.setUser_password(password);
            user.setRoleID(roleId);

            boolean addrole = userDao.addUser(user);
            JSONObject jsonObject=new JSONObject();
            if(addrole){
                jsonObject.put("message","添加成功");
                jsonObject.put("status","success");
            }else {
                jsonObject.put("message","添加失败");
                jsonObject.put("status","fail");
            }
            roleDao.conn.close();
            userDao.conn.close();
            resp.setContentType("application/json;charset=utf-8");
            String jsonString=jsonObject.toJSONString();
            System.out.println(jsonString);
            resp.getWriter().println(jsonString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
