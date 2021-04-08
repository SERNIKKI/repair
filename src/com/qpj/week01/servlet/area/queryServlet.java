package com.qpj.week01.servlet.area;

import com.alibaba.fastjson.JSON;
import com.qpj.week01.been.AreaInfo;
import com.qpj.week01.been.ReturnData;
import com.qpj.week01.dao.AreaDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class queryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryName = request.getParameter("queryName");
        String pageNumber = request.getParameter("pageIndex");
        String offset = request.getParameter("offset");
        String pageSize = request.getParameter("pageSize");
        //前端分页方法
//        frontPageing(response);
        backPaging(queryName,pageNumber,offset,pageSize,response);
    }

    private void backPaging(String queryName,String pageNumber,String offset,String pageSize,HttpServletResponse response) throws IOException{
        //后端分页输出
        ReturnData<AreaInfo> returnData = new ReturnData<>();
        //设置为json类型输出
        response.setContentType("application/json;charset=utf-8");

        AreaDao areaDao = new AreaDao();
        List<AreaInfo> querylist = new ArrayList<>();
        int ioffset = Integer.parseInt(offset);
        int ipageNumber = Integer.parseInt(pageNumber);
        int ipageSize = Integer.parseInt(pageSize);
        String building = null;
        int rows = 0;
        if(queryName!=null&&!queryName.isEmpty()){
            building = queryName;
        }
        try {
            querylist = areaDao.selectBy(building,ipageNumber,ipageSize);
            rows = areaDao.countRows(building);
            areaDao.conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        //得到总页数
        returnData.setTotal(rows);
        returnData.setRows(querylist);
//        System.out.println(querylist);
        String result = JSON.toJSONString(returnData);
//        System.out.println(result);
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();

    }
    private void frontPageing(HttpServletResponse response) throws IOException{
        //前端分页数据输出
        //设置为Json类型输出
        response.setContentType("application/json;charset=utf-8");
        List<AreaInfo> list = new ArrayList<>();
        list.add(new AreaInfo(1,"1号楼","1层"));
        list.add(new AreaInfo(2,"2号楼","5层"));
        list.add(new AreaInfo(3,"3号楼","2层"));
        list.add(new AreaInfo(4,"2号楼","3层"));
        list.add(new AreaInfo(5,"3号楼","5层"));
        list.add(new AreaInfo(6,"3号楼","6层"));
        list.add(new AreaInfo(7,"1号楼","4层"));
        list.add(new AreaInfo(8,"1号楼","2层"));
        list.add(new AreaInfo(9,"2号楼","4层"));
        list.add(new AreaInfo(10,"3号楼","4层"));
        list.add(new AreaInfo(11,"3号楼","3层"));
        list.add(new AreaInfo(12,"1号楼","1层"));
        String result = JSON.toJSONString(list);

        PrintWriter out = response.getWriter();
        out.println(result);
        System.out.println(result);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
