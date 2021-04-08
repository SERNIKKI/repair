package com.qpj.week01.servlet.role;

import com.alibaba.fastjson.JSON;
import com.qpj.week01.been.ReturnData;
import com.qpj.week01.been.RoleInfo;
import com.qpj.week01.dao.RoleDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleListServlet extends HttpServlet {
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
        ReturnData<RoleInfo> returnData = new ReturnData<>();
        resp.setContentType("text/json;charset=utf-8");
        List<RoleInfo> list = new ArrayList<>();
        int ioffset=Integer.parseInt(offset);
        int ipageNumber=Integer.parseInt(pageNumber);
        int ipageSize=Integer.parseInt(pageSize);
        String condition = null;
        if(queryName!=null&& !queryName.isEmpty()){
            condition=" and role_name like'%"+queryName+"%'";
        }
        RoleDao roleDao = new RoleDao();
        list = roleDao.selectBy(condition,ipageNumber,ipageSize);
        int rows= roleDao.countRows(condition);
        returnData.setTotal(rows);
        returnData.setRows(list);
        roleDao.conn.close();
        String result= JSON.toJSONString(returnData);
        PrintWriter out=resp.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
