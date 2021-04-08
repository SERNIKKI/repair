package com.qpj.week01.dao;

import com.qpj.week01.been.AreaInfo;
import com.qpj.week01.been.EquInfo;
import com.qpj.week01.been.RepairInfoVo;
import com.qpj.week01.utils.DBUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairDao implements RepairDaoImpl{
    private final QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    public Connection conn = DBUtils.getConnection();
    /**
     * 查询所有表中内容,用于在列表上显示
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<RepairInfoVo> selectAll() throws SQLException {
        String sql = "SELECT repair_info.id,maintenanceSN,building,floor,equ_info.equ_name,user.user_name,repair_info.reportContent,repair_info.imageURL,repair_info.location,repair_info.status,repair_info.startTime\n" +
                "FROM repair_info,area_Info,equ_info,user\n" +
                "WHERE repair_info.areaID = area_Info.id AND repair_info.equipmentID = equ_info.id AND repair_info.reportUserID = user.id";
        List<RepairInfoVo> repairInfoVos = new ArrayList<>();
        repairInfoVos = queryRunner.query(conn,sql,new BeanListHandler<RepairInfoVo>(RepairInfoVo.class));
        return repairInfoVos;
    }

    /**
     * @param equipmentName
     * @param building
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @Override
    public List<RepairInfoVo> selectBy(String equipmentName, String building, int status, int pageNum, int pageSize) throws SQLException {
        String sql = "SELECT repair_info.id,maintenanceSN,building,floor,equ_info.equ_name,user.user_name,repair_info.reportContent,repair_info.imageURL,repair_info.location,repair_info.status,repair_info.startTime\n" +
                "FROM repair_info,area_Info,equ_info,user\n" +
                "WHERE repair_info.areaID = area_Info.id AND repair_info.equipmentID = equ_info.id AND repair_info.reportUserID = user.id";
        if(building!=null && !building.isEmpty()){
            sql += " AND area_Info.building LIKE '%" + building +"%'";
        }
        if(equipmentName!=null && !equipmentName.isEmpty()){
            sql += " AND equ_info.equ_name LIKE '%" + equipmentName +"%'";
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
     * @param building
     * @param status
     * @return
     * @throws SQLException
     */
    @Override
    public int countRows(String equipmentName, String building, int status) throws SQLException {
        String sql = "SELECT COUNT(*)\n" +
                "FROM repair_info,area_Info,equ_info,user\n" +
                "WHERE repair_info.areaID = area_Info.id AND repair_info.equipmentID = equ_info.id AND repair_info.reportUserID = user.id";
        if(building!=null && !building.isEmpty()){
            sql += " AND area_Info.building LIKE '%" + building +"%'";
        }
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
     * 查询有非重复的楼栋名
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<String> selectBuilding() throws SQLException {
        String sql = "SELECT DISTINCT building FROM area_Info WHERE 1 = 1";
        List<String> buildings = new ArrayList<>();
        List<AreaInfo> areaInfos = queryRunner.query(conn,sql,new BeanListHandler<AreaInfo>(AreaInfo.class));
        for(AreaInfo areaInfo:areaInfos)
            buildings.add(areaInfo.getBuilding());
        return buildings;
    }

    /**
     * 根据楼栋名查询楼层
     *
     * @param building
     * @return
     * @throws SQLException
     */
    @Override
    public List<AreaInfo> selectFloor(String building) throws SQLException {
        String sql = "SELECT floor,id FROM area_Info WHERE building = '" + building + "'";
        List<AreaInfo> areaInfos = queryRunner.query(conn,sql,new BeanListHandler<AreaInfo>(AreaInfo.class));
        return areaInfos;
    }

    /**
     * 查询所有非重复的设备类型
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<String> selectEquType() throws SQLException {
        String sql = "SELECT DISTINCT equ_style FROM equ_info";
        List<String> equType = new ArrayList<>();
        List<EquInfo> equInfos = queryRunner.query(conn,sql,new BeanListHandler<EquInfo>(EquInfo.class));
        for(EquInfo equInfo:equInfos)
            equType.add(equInfo.getEqu_style());
        return equType;
    }

    /**
     * 根据设备类型查询设备名称
     *
     * @param equType
     * @return
     * @throws SQLException
     */
    @Override
    public List<EquInfo> selectEquName(String equType) throws SQLException {
        String sql = "SELECT equ_name,id FROM equ_info WHERE equ_style = '" + equType + "'";
        List<EquInfo> equInfos = queryRunner.query(conn,sql,new BeanListHandler<EquInfo>(EquInfo.class));
        return equInfos;
    }

    /**
     * 向表中插入数据
     *
     * @param repairInfoVo
     * @return
     * @throws SQLException
     */
    @Override
    public boolean insert(RepairInfoVo repairInfoVo) throws SQLException {
        String sql = "ALTER TABLE repair_info AUTO_INCREMENT =1;\n" +
                "INSERT INTO repair_info(maintenanceSN,areaID,equipmentID,reportUserID,reportContent,imageURL,location,startTime,acceptTime) VALUES (?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        repairInfoVo.setAcceptTime(sm.format(date));
        repairInfoVo.setStartTime(sm.format(date));
        Object[] params = new Object[]{repairInfoVo.getMaintenanceSN(),repairInfoVo.getAreaID(),repairInfoVo.getEquipmentID()
        ,repairInfoVo.getReportUserID(),repairInfoVo.getReportContent(),repairInfoVo.getImageURL(),repairInfoVo.getLocation()
        ,repairInfoVo.getStartTime(),repairInfoVo.getAcceptTime()};
        int update = queryRunner.update(conn,sql,params);
        return update>0;
    }

    /**
     * 查询表中是否已经存在相同数据
     *
     * @param areaID
     * @param equipmentID
     * @return
     * @throws SQLException
     */
    @Override
    public boolean selectByEU(int areaID, int equipmentID) throws SQLException {
        String sql = "SELECT * FROM repair_info WHERE areaID = " + areaID + " AND equipmentID = " + equipmentID;
        List<RepairInfoVo> repairInfoVos = null;
        repairInfoVos = queryRunner.query(conn,sql,new BeanListHandler<RepairInfoVo>(RepairInfoVo.class));
//        System.out.println(repairInfoVos);
        return repairInfoVos == null || repairInfoVos.size() ==0;
    }

    /**
     * 修改方法
     *
     * @param repairInfoVo
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(RepairInfoVo repairInfoVo) throws SQLException {
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        repairInfoVo.setAcceptTime(sm.format(date));
        repairInfoVo.setStartTime(sm.format(date));
        String sql = "UPDATE repair_info SET maintenanceSN = '" + repairInfoVo.getMaintenanceSN() + "',areaID = " + repairInfoVo.getAreaID()
                + ",equipmentID = " + repairInfoVo.getEquipmentID() + ",reportUserID = " + repairInfoVo.getReportUserID()
                + ",reportContent = '" + repairInfoVo.getReportContent() + "',imageURL = '" + repairInfoVo.getImageURL()
                + "',location = '" + repairInfoVo.getLocation() + "',startTime = '" + repairInfoVo.getStartTime()
                +"',acceptTime = '" + repairInfoVo.getAcceptTime() + "' WHERE id = " + repairInfoVo.getId();
        int update = queryRunner.update(conn,sql);
        return update>0;
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM repair_info WHERE id = " + id;
        int delete = queryRunner.update(conn,sql);
        return delete>0;
    }

}
