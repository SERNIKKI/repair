package com.qpj.week01.been;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EquInfo {
    private int id;
    private int equipmentID;
    private String equ_name;
    private String equ_style;
    private String responsible;
    private String remark;
    private String update_time;

    public EquInfo(int equipmentID, String equ_name, String equ_style, String responsible, String remark, String update_time) {
        this.equipmentID = equipmentID;
        this.equ_name = equ_name;
        this.equ_style = equ_style;
        this.responsible = responsible;
        this.remark = remark;
        this.update_time = update_time;
    }

    public EquInfo(int id, int equipmentID, String equ_name, String equ_style, String responsible, String remark, String update_time) {
        this.id = id;
        this.equipmentID = equipmentID;
        this.equ_name = equ_name;
        this.equ_style = equ_style;
        this.responsible = responsible;
        this.remark = remark;
        this.update_time = update_time;
    }

    public EquInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEqu_name() {
        return equ_name;
    }

    public void setEqu_name(String equ_name) {
        this.equ_name = equ_name;
    }

    public String getEqu_style() {
        return equ_style;
    }

    public void setEqu_style(String equ_style) {
        this.equ_style = equ_style;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "EquInfo{" +
                "id=" + id +
                ", equipmentID=" + equipmentID +
                ", equ_name='" + equ_name + '\'' +
                ", equ_style='" + equ_style + '\'' +
                ", responsible='" + responsible + '\'' +
                ", remark='" + remark + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
