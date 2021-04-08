package com.qpj.week01.dao;

import com.qpj.week01.been.RepairInfoVo;

import java.sql.SQLException;
import java.util.List;

public interface AssignDaoImpl {
    /**
     *
     * @param equ_name
     * @param maintainUser
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    List<RepairInfoVo> selectAll(String equ_name,String maintainUser, int status, int pageNum, int pageSize) throws SQLException;

    /**
     *
     * @param equipmentName
     * @param maintainUser
     * @param status
     * @return
     * @throws SQLException
     */
    int countRows(String equipmentName,String maintainUser,int status) throws SQLException;

    /**
     *
     * @param repairInfoVo
     * @return
     * @throws SQLException
     */
    boolean update(RepairInfoVo repairInfoVo) throws SQLException;
}
