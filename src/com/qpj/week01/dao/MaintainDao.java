package com.qpj.week01.dao;

import com.qpj.week01.been.RepairInfoVo;
import com.qpj.week01.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaintainDao implements MaintainDaoImpl{
    private final QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    public Connection conn = DBUtils.getConnection();
    /**
     * 查询
     *
     * @param equ_name
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @Override
    public List<RepairInfoVo> selectAll(String equ_name, int status, int pageNum, int pageSize) throws SQLException {
        String sql = "SELECT repair_info.id,maintenanceSN,building,floor,equ_info.equ_name,repair_info.reportContent,repair_info.imageURL,repair_info.location,repair_info.status,repair_info.startTime,repair_info.maintenanceContent,repair_info.endTime\n" +
                "FROM area_Info,equ_info,repair_info,user\n" +
                "WHERE repair_info.areaID = area_Info.id AND repair_info.equipmentID = equ_info.id AND repair_info.reportUserID = user.id";
        if(equ_name!=null && !equ_name.isEmpty()){
            sql += " AND equ_info.equ_name LIKE '%" + equ_name +"%'";
        }
        if(status==0||status==1||status==2){
            sql += " AND repair_info.status LIKE '%" + status +"%'";
        }
        if(pageSize > 0){
            sql += " limit " + pageSize*(pageNum-1) + " , " + pageSize;
        }
        List<RepairInfoVo> repairInfoVos = new ArrayList<>();
        repairInfoVos = queryRunner.query(conn,sql,new BeanListHandler<RepairInfoVo>(RepairInfoVo.class));
        return repairInfoVos;
    }

    /**
     * @param equipmentName
     * @param status
     * @return
     * @throws SQLException
     */
    @Override
    public int countRows(String equipmentName, int status) throws SQLException {
        String sql = "SELECT COUNT(*)\n" +
                "FROM repair_info,area_Info,equ_info,user\n" +
                "WHERE repair_info.areaID = area_Info.id AND repair_info.equipmentID = equ_info.id AND repair_info.reportUserID = user.id";
        if(equipmentName!=null && !equipmentName.isEmpty()){
            sql += " AND equ_info.equ_name LIKE '%" + equipmentName +"%'";
        }
        if(status==0||status==1||status==2){
            sql += " AND repair_info.status LIKE '%" + status +"%'";
        }
        Number query = queryRunner.query(conn, sql, new ScalarHandler<>());
        return query.intValue();
    }

    /**
     * @param repairInfoVo
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(RepairInfoVo repairInfoVo) throws SQLException {
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        repairInfoVo.setEndTime(sm.format(date));
        String sql = "UPDATE repair_info SET maintenanceContent = '" + repairInfoVo.getMaintenanceContent() + "',status = " + repairInfoVo.getStatus()
                +",endTime = '" + repairInfoVo.getEndTime() + "' WHERE id = " + repairInfoVo.getId();
        int update = queryRunner.update(conn,sql);
        return update>0;
    }

    /**
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<RepairInfoVo> selectByID(int id) throws SQLException {
        String sql = "SELECT repair_info.id,maintenanceSN,building,floor,equ_info.equ_name,equ_info.equ_style,repair_info.reportContent,repair_info.imageURL,repair_info.location,repair_info.status,repair_info.startTime,repair_info.maintenanceContent,repair_info.endTime,areaID,repair_info.equipmentID,reportUserID,maintenanceContent,maintenanceUserID,user.user_name\n" +
                "FROM area_Info,equ_info,repair_info,user\n" +
                "WHERE repair_info.areaID = area_Info.id AND repair_info.equipmentID = equ_info.id AND repair_info.reportUserID = user.id AND reportUserID = " + id;
        List<RepairInfoVo> repairInfoVos = queryRunner.query(conn,sql,new BeanListHandler<RepairInfoVo>(RepairInfoVo.class));
        return repairInfoVos;
    }


}
