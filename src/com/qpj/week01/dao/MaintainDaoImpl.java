package com.qpj.week01.dao;

import com.qpj.week01.been.RepairInfoVo;

import java.sql.SQLException;
import java.util.List;

public interface MaintainDaoImpl {
    /**
     * 查询
     * @param equ_name
     * @param status
     * @return
     * @throws SQLException
     */
    List<RepairInfoVo> selectAll(String equ_name,int status,int pageNum, int pageSize) throws SQLException;

    /**
     *
     * @param equipmentName
     * @param status
     * @return
     * @throws SQLException
     */
    int countRows(String equipmentName,int status) throws SQLException;

    /**
     *
     * @param repairInfoVo
     * @return
     * @throws SQLException
     */
    boolean update(RepairInfoVo repairInfoVo) throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    List<RepairInfoVo> selectByID(int id) throws SQLException;
}
