package com.qpj.week01.dao;

import com.qpj.week01.been.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserDaoImpl {
    /**
     * 根据用户名查询用户id
     *
     * @param name
     * @return
     * @throws SQLException
     */
    UserInfo selectByName(String name) throws SQLException;

    /**
     * @param id
     * @return
     * @throws SQLException
     */
    String selectById(int id) throws SQLException;

    /**
     * @return
     * @throws SQLException
     */
    List<UserInfo> selectAll() throws SQLException;

    /**
     * @param name
     * @param password
     * @return
     * @throws SQLException
     */
    boolean login(String name, String password) throws SQLException;

    /**
     * @param userInfo
     * @return
     * @throws SQLException
     */
    boolean addUser(UserInfo userInfo) throws SQLException;

    /**
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    List<UserInfo> selectBy(String condition, int pageNum, int pageSize) throws SQLException;

    /**
     * @param condition
     * @return
     * @throws SQLException
     */
    int countRows(String condition) throws SQLException;

    /**
     * @param user
     * @return
     * @throws SQLException
     */
    boolean update(UserInfo user) throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    boolean delete(int id) throws SQLException;
}
