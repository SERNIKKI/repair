package com.qpj.week01.servlet.assign;

import com.alibaba.fastjson.JSON;
import com.qpj.week01.been.RepairInfoVo;
import com.qpj.week01.been.ReturnData;
import com.qpj.week01.dao.AssignDao;
import com.qpj.week01.dao.MaintainDao;
import com.qpj.week01.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AssignListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String equipmentName = req.getParameter("equipmentName");
        String MaintainUserName = req.getParameter("MaintainUserName");
        String status = req.getParameter("status");
        String pageNumber = req.getParameter("pageIndex");
        String offset = req.getParameter("offset");
        String pageSize = req.getParameter("pageSize");
        System.out.println(MaintainUserName);
//        System.out.println("equipmentName: " + equipmentName + " building: " + building + " status:" + status +
//                " pageNumber:" + pageNumber + " offset" + offset + " pageSize:" + pageSize);
        int statu = -1;
        if(status!=null && !status.isEmpty()){
            statu = Integer.parseInt(status);
        }
        backPaging(equipmentName,MaintainUserName,statu,pageNumber,offset,pageSize,resp);

    }
    private void backPaging(String equipmentName,String maintainUserNameint,int  status,String pageNumber,String offset,String pageSize,HttpServletResponse response) throws IOException{
        //后端分页输出
        ReturnData<RepairInfoVo> returnData = new ReturnData<>();
        //设置为json类型输出
        response.setContentType("application/json;charset=utf-8");

        AssignDao assignDao = new AssignDao();
        UserDao userDao = new UserDao();
        List<RepairInfoVo> querylist = new ArrayList<>();
        int ioffset = Integer.parseInt(offset);
        int ipageNumber = Integer.parseInt(pageNumber);
        int ipageSize = Integer.parseInt(pageSize);
        String equ_name = null;
        int statu = -1;
        int rows = 0;
        if(equipmentName!=null&&!equipmentName.isEmpty()){
            equ_name = equipmentName;
        }
        if(status==0||status==1||status==2){
            statu = status;
        }
        try {
            querylist = assignDao.selectAll(equ_name,maintainUserNameint,statu,ipageNumber,ipageSize);
            for (RepairInfoVo repairInfoVo : querylist) {
                if (repairInfoVo.getMaintenanceUserID() > 0) {
                    repairInfoVo.setUser_name(userDao.selectById(repairInfoVo.getMaintenanceUserID()));
                } else {
                    repairInfoVo.setUser_name(null);
                }
            }
            rows = assignDao.countRows(equ_name,maintainUserNameint,statu);
            assignDao.conn.close();
            userDao.conn.close();
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
