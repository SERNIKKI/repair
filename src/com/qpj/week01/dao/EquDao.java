package com.qpj.week01.dao;

import com.qpj.week01.been.AreaInfo;
import com.qpj.week01.been.EquInfo;
import com.qpj.week01.utils.DBUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquDao implements EquDaoImpl{
    private final QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    public Connection conn = DBUtils.getConnection();
    /**
     * curd -新增、修改、删除、查询
     * 分页查询、模糊查询
     *
     * @param equInfo
     */
    @Override
    public boolean insert(EquInfo equInfo) throws SQLException {
        //设置自增时每次按照最大值自增
        //building和floor均与数据库中重复时不执行插入操作
        String sql = "ALTER TABLE equ_info AUTO_INCREMENT =1;\n" +
                "INSERT INTO equ_info(equipmentID,equ_name,equ_style,responsible,remark,update_time) VALUES (?,?,?,?,?,?)";
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        equInfo.setUpdate_time(sm.format(date));
        Object[] params = new Object[]{equInfo.getEquipmentID(),equInfo.getEqu_name(),equInfo.getEqu_style(),equInfo.getResponsible(),equInfo.getRemark(),equInfo.getUpdate_time()};
        int update = queryRunner.update(conn,sql,params);
        return update>0;
    }

    @Override
    public boolean update(EquInfo equInfo) throws SQLException {
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        equInfo.setUpdate_time(sm.format(date));
        String sql = "update equ_info set equ_name = '" +equInfo.getEqu_name()+"',equ_style = '" + equInfo.getEqu_style() + "',responsible = '"
                +equInfo.getResponsible() +"',remark = '" + equInfo.getRemark() +"',update_time = '" + equInfo.getUpdate_time() +"' where id = "+equInfo.getId();
//        Object params = new Object[]{areaInfo.getBuilding(),areaInfo.getFloor()};
//        System.out.println(params);
        int update = queryRunner.update(conn,sql);
        return update>0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "delete from equ_info where id = " + id;
        int update = queryRunner.update(conn,sql);
        return update>0;
    }

    @Override
    public EquInfo selectOne(int id) throws SQLException {
        String sql = "select * from equ_info where id = " + id;
        EquInfo equInfo = queryRunner.query(conn,sql,new BeanHandler<EquInfo>(EquInfo.class));
        return equInfo;
    }

    @Override
    public List<EquInfo> selectAll() {
        String sql = "SELECT * FROM `equ_info` WHERE 1";
        List<EquInfo> list = new ArrayList<>();
        try {
            list = queryRunner.query(conn,sql,new BeanListHandler<EquInfo>(EquInfo.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 按照设备名称，设备类型进行模糊查询，并且可以进行分页
     *
     * @param equ_name,equ_style
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @Override
    public List<EquInfo> selectBy(String equ_name,String equ_style, int pageNum, int pageSize) throws SQLException {
        String sql = "select * from equ_info where 1 = 1";
        if(equ_name!=null && !equ_name.isEmpty()){
            sql += " and equ_name like '%" + equ_name +"%'";
        }
        if(equ_style!=null && !equ_style.isEmpty()){
            sql += " and equ_style like '%" + equ_style +"%'";
        }
        if(pageSize > 0){
            sql += " limit " + pageSize*(pageNum-1) + " , " + pageSize;
        }
        List<EquInfo> list = queryRunner.query(conn,sql,new BeanListHandler<EquInfo>(EquInfo.class));
        return list;
    }

    /**
     * 返回当前表中所有的记录数、记录总数、分页操作用
     *
     * @param equ_name,equ_style
     * @return
     * @throws SQLException
     */
    @Override
    public int countRows(String equ_name,String equ_style) throws SQLException {
        String sql = "select count(*) from equ_info where 1 = 1";
        if(equ_name!=null && !equ_name.isEmpty()){
            sql += " and equ_name like '%" + equ_name +"%'";
        }
        if(equ_style!=null && !equ_style.isEmpty()){
            sql += " and equ_style like '%" + equ_style +"%'";
        }
        Number query = queryRunner.query(conn, sql, new ScalarHandler<>());
        return query.intValue();
    }

    public int maxID() throws SQLException{
        int maxID = 0;
        if(countRows("","")==0){
            maxID = 10000;
        }else{
            String sql = "select MAX(equipmentID) from equ_info where 1 = 1";
            Number query = queryRunner.query(conn, sql, new ScalarHandler<>());
            maxID = query.intValue() + 1;
        }
        return maxID;
    }
}
