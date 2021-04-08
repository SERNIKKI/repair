package com.qpj.week01.dao;

import com.qpj.week01.been.AreaInfo;
import com.qpj.week01.been.EquInfo;
import com.qpj.week01.been.RepairInfoVo;

import java.sql.SQLException;
import java.util.List;

public interface RepairDaoImpl {
    /**
     * 查询所有表中内容,用于在列表上显示
     * @return
     * @throws SQLException
     */
    List<RepairInfoVo> selectAll() throws SQLException;

    /**
     *
     * @param equipmentName
     * @param building
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    List<RepairInfoVo> selectBy(String equipmentName, String building,int status, int pageNum, int pageSize) throws SQLException;

    /**
     *
     * @param equipmentName
     * @param building
     * @param status
     * @return
     * @throws SQLException
     */
    int countRows(String equipmentName, String building,int status) throws SQLException;

    /**
     * 查询有非重复的楼栋名
     * @return
     * @throws SQLException
     */
    List<String> selectBuilding() throws SQLException;

    /**
     * 根据楼栋名查询楼层，和对应的id
     * @param building
     * @return
     * @throws SQLException
     */
    List<AreaInfo> selectFloor(String building) throws SQLException;

    /**
     * 查询所有非重复的设备类型
     * @return
     * @throws SQLException
     */
    List<String> selectEquType() throws SQLException;

    /**
     * 根据设备类型查询设备名称和设备id
     * @param equType
     * @return
     * @throws SQLException
     */
    List<EquInfo> selectEquName(String equType) throws SQLException;

    /**
     * 向表中插入数据
     * @return
     * @throws SQLException
     */
    boolean insert(RepairInfoVo repairInfoVo) throws SQLException;

    /**
     * 查询表中是否已经存在相同数据
     * @param areaID
     * @param equipmentID
     * @return
     * @throws SQLException
     */
    boolean selectByEU(int areaID,int equipmentID) throws SQLException;

    /**
     * 修改方法
     * @param repairInfoVo
     * @return
     * @throws SQLException
     */
    boolean update(RepairInfoVo repairInfoVo) throws SQLException;

    /**
     * 删除数据
     * @param id
     * @return
     * @throws SQLException
     */
    boolean delete(int id) throws SQLException;
}
