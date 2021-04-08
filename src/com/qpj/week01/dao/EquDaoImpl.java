package com.qpj.week01.dao;

import com.qpj.week01.been.EquInfo;

import java.sql.SQLException;
import java.util.List;

public interface EquDaoImpl {
    /**
     *
     * curd -新增、修改、删除、查询
     * 分页查询、模糊查询
     */
    boolean insert(EquInfo equInfo) throws SQLException;
    boolean update(EquInfo equInfo) throws SQLException;
    boolean delete(int id) throws SQLException;
    EquInfo selectOne(int id) throws SQLException;
    List<EquInfo> selectAll();

    /**
     * 按照楼栋号进行模糊查询，并且可以进行分页
     * @param equ_name,equ_style
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    List<EquInfo> selectBy(String equ_name,String equ_style, int pageNum, int pageSize) throws SQLException;

    /**
     * 返回当前表中所有的记录数、记录总数、分页操作用
     * @param equ_name,equ_style
     * @return
     * @throws SQLException
     */
    int countRows(String equ_name,String equ_style) throws SQLException;

    int maxID() throws SQLException;
}
