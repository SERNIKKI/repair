package com.qpj.week01.dao;

import com.qpj.week01.been.AreaInfo;
import com.qpj.week01.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDao implements AreaDaoImpl{
    private final QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    public Connection conn = DBUtils.getConnection();
    /**
     * curd -新增、修改、删除、查询
     * 分页查询、模糊查询
     *
     * @param areaInfo
     */
    @Override
    public boolean insert(AreaInfo areaInfo) throws SQLException {
        //初始数据库数据条数
        int begin = selectAll().size();
        //设置自增时每次按照最大值自增
        //building和floor均与数据库中重复时不执行插入操作
        String sql = "ALTER TABLE area_Info AUTO_INCREMENT =1;\n" +
                "INSERT IGNORE INTO area_Info(building,floor) VALUES (?,?)";
        Object[] params = new Object[]{areaInfo.getBuilding(),areaInfo.getFloor()};
        int update = queryRunner.update(conn,sql,params);
        //执行插入语句之后
        int end = selectAll().size();
        return begin != end;
    }

    @Override
    public boolean update(AreaInfo areaInfo) throws SQLException {
        String sql = "update area_Info set building = '" +areaInfo.getBuilding()+"',floor = '" + areaInfo.getFloor() + "' where id = "+areaInfo.getId();
//        Object params = new Object[]{areaInfo.getBuilding(),areaInfo.getFloor()};
//        System.out.println(params);
        int update = queryRunner.update(conn,sql);
        return update>0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "delete from area_Info where id = " + id;
        int update = queryRunner.update(conn,sql);
        return update>0;
    }

    @Override
    public AreaInfo selectOne(int id) throws SQLException {
        String sql = "select * from area_Info where id = " + id;
        AreaInfo areaInfo = queryRunner.query(conn,sql,new BeanHandler<AreaInfo>(AreaInfo.class));
        return areaInfo;
    }

    @Override
    public List<AreaInfo> selectAll(){
        String sql = "SELECT * FROM `area_Info` WHERE 1";
        List<AreaInfo> list = new ArrayList<>();
        try {
            list = queryRunner.query(conn,sql,new BeanListHandler<AreaInfo>(AreaInfo.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 按照楼栋号进行模糊查询，并且可以进行分页
     *
     * @param building
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @Override
    public List<AreaInfo> selectBy(String building, int pageNum, int pageSize) throws SQLException {
        String sql = "select id,building,floor from area_Info where 1 = 1";
        if(building!=null && !building.isEmpty()){
            sql += " and building like '%" + building +"%'";
        }
        if(pageSize > 0){
            sql += " limit " + pageSize*(pageNum-1) + " , " + pageSize;
        }
        List<AreaInfo> list = queryRunner.query(conn,sql,new BeanListHandler<AreaInfo>(AreaInfo.class));
        return list;
    }

    /**
     * 返回当前表中所有的记录数、记录总数、分页操作用
     *
     * @param building
     * @return
     * @throws SQLException
     */
    @Override
    public int countRows(String building) throws SQLException {
        String sql = "select count(*) from area_Info where 1 = 1";
        if(building!=null && !building.isEmpty()){
            sql += " and building like '%" + building +"%'";
        }
        Number query = queryRunner.query(conn, sql, new ScalarHandler<>());
        return query.intValue();
    }
}
