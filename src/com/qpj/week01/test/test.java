package com.qpj.week01.test;



import com.qpj.week01.been.EquInfo;
import com.qpj.week01.been.RepairInfoVo;
import com.qpj.week01.dao.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
//        RhesisDao rhesisDao = new RhesisDao();
//        List<Rhesis> list = rhesisDao.selectAll();
//        System.out.println(list.toString());
        /*--------------------------------------------*/
//        Connection connection = DBUtils.getConnection();
//        System.out.println(connection);
//        if (connection != null)
//            System.out.println("连接成功");
//        connection.close();
        /*--------------------------------------------*/
//        RhesisDao rhesisDao = new RhesisDao();
//        System.out.println(rhesisDao.selectAll().toString());
        /*---------------------测试增加楼层信息-----------------------*/
//        AreaDao areaDao = new AreaDao();
//        AreaInfo areaInfo = new AreaInfo();
//        areaInfo.setBuilding("1号楼");
//        areaInfo.setFloor("2层");
//        System.out.println(areaDao.insert(areaInfo));
        /*---------------------测试查询所有楼层信息-----------------------*/
//        System.out.println(areaDao.selectAll());
        /*---------------------测试查询所有楼层信息-----------------------*/
//        EquDao equDao = new EquDao();
//        System.out.println(equDao.insert(new EquInfo(10001,"1","1","1","1","")));
//        System.out.println(equDao.selectAll());
//        System.out.println(equDao.maxID());
        AssignDao assignDao = new AssignDao();
//        for (RepairInfoVo repairInfoVo:repairDao.selectBy("格","2",0,1,5)){
//            System.out.println(repairInfoVo.getEqu_name());
//        }
//        RepairInfoVo repairInfoVo = new RepairInfoVo();
//        repairInfoVo.setId(1);
//        repairInfoVo.setMaintenanceUserID(6);
//        System.out.println(assignDao.update(repairInfoVo));
        UserDao userDao = new UserDao();
//        System.out.println(userDao.login("NIKKI","sernikki000602"));
//        UserDao userDao1 = new UserDao();
//        System.out.println(userDao1.selectByName("NIKKI"));
        List<RepairInfoVo> repairInfoVos = null;
        MaintainDao maintainDao  = new MaintainDao();
        RepairDao repairDao = new RepairDao();
//        repairInfoVos = maintainDao.selectByID(7);
//        for (RepairInfoVo repairInfoVo : repairInfoVos) {
//            if(repairInfoVo.getMaintenanceUserID() > 0) {
//                repairInfoVo.setMaintenanceUserName(userDao.selectById(repairInfoVo.getMaintenanceUserID()));
//            }
//        }
        System.out.println(repairDao.selectFloor("2号楼"));
    }
}
