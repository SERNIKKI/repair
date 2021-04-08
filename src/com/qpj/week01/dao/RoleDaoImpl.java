package com.qpj.week01.dao;

import com.qpj.week01.been.RoleInfo;

import java.sql.SQLException;
import java.util.List;

public interface RoleDaoImpl {
    /**
     *
     * @param roleInfo
     * @return
     */
    boolean add(RoleInfo roleInfo);

    /**
     *
     * @param id
     * @param name
     * @return
     * @throws SQLException
     */
    boolean update(int id,String name) throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    boolean delete(int id) throws SQLException;

    /**
     *
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    List<RoleInfo> selectBy(String condition, int pageNum, int pageSize)throws SQLException;

    /**
     *
     * @param condition
     * @return
     * @throws SQLException
     */
    int countRows(String condition)throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    List<String> selectAllName() throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    String selectbyID(int id)throws SQLException;

    /**
     *
     * @param name
     * @return
     * @throws SQLException
     */
    int selectID(String name)throws SQLException;

}
