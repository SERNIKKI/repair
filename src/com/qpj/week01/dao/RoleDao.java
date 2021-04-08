package com.qpj.week01.dao;

import com.qpj.week01.been.RoleInfo;
import com.qpj.week01.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class RoleDao {
    private final QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    public Connection conn = DBUtils.getConnection();

    public boolean add(RoleInfo roleInfo) {
        // 提供执行的sql
        String sql ="ALTER TABLE role_info AUTO_INCREMENT =1;\n" +
                "INSERT INTO role_info(role_name) VALUES (?)";//不改名吗
        Object[] params = new Object[]{roleInfo.getRole_name()};
        // 执行查询，并返回所需要的类型
        int rows = 0;
        try {
            rows = queryRunner.update(conn,sql,params);
        } catch (SQLException e) {
            return false;
        }
        return rows>0;
    }
    public boolean update(int id,String name) throws SQLException {
        String sql="update role_info set role_name=? where id=?";
        Object[] params=new Object[]{name,id};
        int update = queryRunner.update(conn,sql,params);
        return update == 1;
    }
    public boolean delete(int id) throws SQLException{
        String sql="delete from role_info where id=?";
        int update=queryRunner.update(conn,sql,id);
        return update == 1;
    }
    public List<RoleInfo> selectBy(String condition, int pageNum, int pageSize)throws SQLException{
        String sql="select id,role_name from role_info where 1=1";
        if(condition!=null&& !condition.isEmpty()){
            sql+=condition;
        }
        sql+=" order by id";
        if(pageSize>0){
            sql+=" limit "+pageSize*(pageNum-1)+" , "+pageSize;
        }

        List<RoleInfo> roleInfoList=queryRunner.query(conn,sql,new BeanListHandler<>(RoleInfo.class));
        return roleInfoList;
    }
    public int countRows(String condition)throws SQLException{
        String sql="select count(*) from role_info where 1=1";
        if(condition!=null&&!condition.isEmpty()){
            sql+=condition;
        }
        Number query=queryRunner.query(conn,sql,new ScalarHandler<>());
        return query.intValue();
    }
    public List<String> selectAllName() throws SQLException{
        QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
        String sql="select DISTINCT role_name from role_info";
        List<String> list=queryRunner.query(conn,sql,new ColumnListHandler<String>("role_name"));
        return list;
    }
    public String selectbyID(int id)throws SQLException{
        QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
        String sql="select role_name from role_info where id = ?";
        Object[] params = new Object[]{id};
        return queryRunner.query(conn,sql,new ScalarHandler<>(),params);
    }
    public int selectID(String name)throws SQLException{
        QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
        String sql="select id from role_info where role_name = ?";
        Object[] params = new Object[]{name};
        return queryRunner.query(conn,sql,new ScalarHandler<>(),params);
    }
}
