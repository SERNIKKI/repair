package com.qpj.week01.servlet.equ;

import com.alibaba.fastjson.JSON;
import com.qpj.week01.been.AreaInfo;
import com.qpj.week01.been.EquInfo;
import com.qpj.week01.been.ReturnData;
import com.qpj.week01.dao.AreaDao;
import com.qpj.week01.dao.EquDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EquListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String equName = req.getParameter("equName");
        String equStyle = req.getParameter("equStyle");
        String pageNumber = req.getParameter("pageIndex");
        String offset = req.getParameter("offset");
        String pageSize = req.getParameter("pageSize");
        //前端分页方法
//        frontPageing(response);
        backPaging(equName,equStyle,pageNumber,offset,pageSize,resp);
    }
    private void backPaging(String equName,String equStyle,String pageNumber,String offset,String pageSize,HttpServletResponse response) throws IOException{
        //后端分页输出
        ReturnData<EquInfo> returnData = new ReturnData<>();
        //设置为json类型输出
        response.setContentType("application/json;charset=utf-8");

        EquDao equDao = new EquDao();
        List<EquInfo> querylist = new ArrayList<>();
        int ioffset = Integer.parseInt(offset);
        int ipageNumber = Integer.parseInt(pageNumber);
        int ipageSize = Integer.parseInt(pageSize);
        String equ_name = null;
        String equ_style = null;
        int rows = 0;
        if(equName!=null&&!equName.isEmpty()){
            equ_name = equName;
        }
        if(equStyle!=null&&!equStyle.isEmpty()){
            equ_style = equStyle;
        }
        try {
            querylist = equDao.selectBy(equ_name,equ_style,ipageNumber,ipageSize);
            rows = equDao.countRows(equ_name,equ_style);
            equDao.conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        //得到总页数
        returnData.setTotal(rows);
        returnData.setRows(querylist);
        String result = JSON.toJSONString(returnData);
//        System.out.println(result);
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();

    }
}
