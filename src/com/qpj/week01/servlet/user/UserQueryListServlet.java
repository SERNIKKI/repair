package com.qpj.week01.servlet.user;

import com.alibaba.fastjson.JSON;
import com.qpj.week01.been.ReturnData;
import com.qpj.week01.been.UserInfo;
import com.qpj.week01.dao.RoleDao;
import com.qpj.week01.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserQueryListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String queryName=req.getParameter("queryName");
        String pageNumber=req.getParameter("pageIndex");
        String offset=req.getParameter("offset");
        String pageSize=req.getParameter("pageSize");
        try {
            backPageing(queryName,pageNumber,offset,pageSize,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void backPageing(String queryName, String pageNumber, String offset, String pageSize, HttpServletResponse resp) throws IOException, SQLException {
        ReturnData<UserInfo> returnData = new ReturnData<>();
        resp.setContentType("text/json;charset=utf-8");

        List<UserInfo> list = new ArrayList<>();
        int ioffset = Integer.parseInt(offset);
        int ipageNumber = Integer.parseInt(pageNumber);
        int ipageSize = Integer.parseInt(pageSize);
        String condition = null;
        if (queryName != null && !queryName.isEmpty()) {
            condition = "AND role_info.role_name LIKE'%" + queryName + "%'";
        }
        UserDao userDao = new UserDao();
        RoleDao roleDao = new RoleDao();
        list = userDao.selectBy(condition,ipageNumber,ipageSize);
        for (UserInfo userInfo : list) {
            if (userInfo.getRoleID() > 0) {
                userInfo.setRole_name(roleDao.selectbyID(userInfo.getRoleID()));
            }
        }
        int rows = userDao.countRows(condition);
        returnData.setTotal(rows);
        returnData.setRows(list);
        String result = JSON.toJSONString(returnData);
        PrintWriter out = resp.getWriter();
        out.println(result);
        userDao.conn.close();
        roleDao.conn.close();
        out.flush();
        out.close();
    }
}
