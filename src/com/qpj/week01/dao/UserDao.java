package com.qpj.week01.dao;

import com.qpj.week01.been.UserInfo;
import com.qpj.week01.servlet.repair.QueryByEquipType;
import com.qpj.week01.utils.DBUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements UserDaoImpl{
    private final QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    public Connection conn = DBUtils.getConnection();
    /**
     * 根据用户名查询用户id
     *
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public UserInfo selectByName(String name) throws SQLException {
        String sql = "SELECT * FROM user WHERE user_name = '" + name + "'";
        UserInfo userInfo = queryRunner.query(conn,sql,new BeanHandler<UserInfo>(UserInfo.class));
        return userInfo;
    }

    /**
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public String selectById(int id) throws SQLException {
        String sql = "SELECT user_name FROM user WHERE id = " + id;
        UserInfo userInfo = queryRunner.query(conn,sql,new BeanHandler<UserInfo>(UserInfo.class));
        return userInfo.getUser_name();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public List<UserInfo> selectAll() throws SQLException {
        String sql = "SELECT * FROM user";
        List<UserInfo> userInfos = queryRunner.query(conn,sql,new BeanListHandler<UserInfo>(UserInfo.class));
        return userInfos;
    }

    /**
     * @param name
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public boolean login(String name, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE user_name = '" + name + "' AND user_password = '" + password + "'";
        UserInfo userInfo = null;
        userInfo = queryRunner.query(conn,sql,new BeanHandler<UserInfo>(UserInfo.class));
        return userInfo!=null;
    }

    /**
     * @param userInfo
     * @return
     * @throws SQLException
     */
    @Override
    public boolean addUser(UserInfo userInfo) throws SQLException {
        String sql = "INSERT INTO user(user_name,user_password,roleID) VALUES (?, ? ,?)";
        Object[] params = new Object[]{userInfo.getUser_name(),userInfo.getUser_password(),userInfo.getRoleID()};
        int rows = 0;
        rows = queryRunner.update(conn,sql,params);
        return rows>0;
    }

    /**
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @Override
    public List<UserInfo> selectBy(String condition, int pageNum, int pageSize) throws SQLException {
        String sql = null;
        if(condition!=null&& !condition.isEmpty()){
            sql = "SELECT user.id,user.user_name,user.user_password,role_name FROM user,role_info WHERE user.roleID = role_info.id ";
            sql+=condition;
        }else {
            sql="select * from user";
        }
        sql+=" order by user.id";
        if(pageSize>0){
            sql+=" limit "+pageSize*(pageNum-1)+" , "+pageSize;
        }
        List<UserInfo> users=queryRunner.query(conn,sql,new BeanListHandler<UserInfo>(UserInfo.class));
//        System.out.println(users);
        return users;
    }

    /**
     * @param condition
     * @return
     * @throws SQLException
     */
    @Override
    public int countRows(String condition) throws SQLException {
        String sql = null;
        if(condition!=null&&!condition.isEmpty()){
            sql="SELECT COUNT(*) FROM user,role_info WHERE user.roleID = role_info.id ";
            sql+=condition;
        }else {
            sql = "select count(*) from user";
        }
        Number query=queryRunner.query(conn,sql,new ScalarHandler<>());
        return query.intValue();
    }

    /**
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public boolean update(UserInfo user) throws SQLException {
        String sql="update user set user_name=? ,user_password=?,roleID=? where id=?";
        Object[] params=new Object[]{user.getUser_name(),user.getUser_password(),user.getRoleID(),user.getId()};
        int update = queryRunner.update(conn,sql,params);
        return update==1;
    }

    /**
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delete(int id) throws SQLException {
        String sql="delete from user where id=?";
        int update=queryRunner.update(conn,sql,id);
        return update==1;
    }


}
