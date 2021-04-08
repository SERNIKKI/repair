package com.qpj.week01.dao;

import com.qpj.week01.been.AreaInfo;

import java.sql.SQLException;
import java.util.List;

public interface AreaDaoImpl {
    /**
     *
     * curd -新增、修改、删除、查询
     * 分页查询、模糊查询
     */
    boolean insert(AreaInfo areaInfo) throws SQLException;
    boolean update(AreaInfo areaInfo) throws SQLException;
    boolean delete(int id) throws SQLException;
    AreaInfo selectOne(int id) throws SQLException;
    List<AreaInfo> selectAll();

    /**
     * 按照楼栋号进行模糊查询，并且可以进行分页
     * @param building
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    List<AreaInfo> selectBy(String building, int pageNum, int pageSize) throws SQLException;

    /**
     * 返回当前表中所有的记录数、记录总数、分页操作用
     * @param condition
     * @return
     * @throws SQLException
     */
    int countRows(String condition) throws SQLException;
}
