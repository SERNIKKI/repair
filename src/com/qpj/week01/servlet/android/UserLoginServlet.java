package com.qpj.week01.servlet.android;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qpj.week01.been.JsonData;
import com.qpj.week01.been.UserInfo;
import com.qpj.week01.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String userName = req.getParameter("username");
        userName = new String(userName.getBytes("ISO-8859-1"),"UTF-8");
        String pwd = req.getParameter("password");
        String tryCode = req.getParameter("code");
        UserDao userDao = new UserDao();
        //开始验证参数的合法性
//        String googleVerifyCode = req.getSession().getAttribute("googleVerifyCode ").toString();
        JsonData<UserInfo> jsonData = new JsonData<>();
        //访问数据库登陆
        try {
            boolean login = userDao.login(userName,pwd);
//            if(!tryCode.equals(googleVerifyCode)){
//                //输入的验证码不正确
//                jsonData.setCode(-1);
//                jsonData.setMessage("输入的验证码不正确，请重新输入！");
//            }else
            if(!login){
                //输入的账号密码不正确，需要重新输入
                jsonData.setCode(-1);
                jsonData.setMsg("输入的用户名或密码不正确，请重新输入！");
            }else {
                //成功
                UserInfo userInfo = userDao.selectByName(userName);
                //构造手机端需要的用户信息，多了token信息
                userInfo.setToken(req.getSession().getId());
                req.getSession().setAttribute("_m_userInfo",userInfo);
                jsonData.setCode(0);
                jsonData.setMsg("登陆成功");
                jsonData.setData(userInfo);
            }
            userDao.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String result = JSON.toJSONString(jsonData, SerializerFeature.WriteNullListAsEmpty);
//        System.out.println(result);
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
