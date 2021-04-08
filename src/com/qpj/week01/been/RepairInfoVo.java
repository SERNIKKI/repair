package com.qpj.week01.been;

public class RepairInfoVo {
    private int id;//id
    private String maintenanceSN;//报修单号

    private int areaID;//区域ID,来源于area_Info表
    private String building;//楼栋名
    private String floor;//楼层名

    private int equipmentID;//设备ID
    private String equ_name;//设备名称
    private String equ_style;//设备类型

    private int reportUserID;//报修人的id,来源于user表
    private String user_name;//user表中报修人的姓名

    private String reportContent;//备注
    private String imageURL;//图片url
    private String location;//详细位置
    /**
     * 表单状态 报修 0 受理 1 完成 2
     */
    private int status;//状态
    //添加时间
    private String startTime;//开始时间
    private int maintenanceUserID;//受理人id,来源于user表
    private String maintenanceUserName;//受理人姓名
    private String acceptTime;//受理时间
    private String maintenanceContent;//维修描述
    private String endTime;//完成时间

    public RepairInfoVo(int id, String maintenanceSN, int areaID, String building, String floor, int equipmentID, String equ_name, String equ_style, int reportUserID, String user_name, String reportContent, String imageURL, String location, int status, String startTime, int maintenanceUserID, String acceptTime, String maintenanceContent, String endTime,String maintenanceUserName) {
        this.id = id;
        this.maintenanceSN = maintenanceSN;
        this.areaID = areaID;
        this.building = building;
        this.floor = floor;
        this.equipmentID = equipmentID;
        this.equ_name = equ_name;
        this.equ_style = equ_style;
        this.reportUserID = reportUserID;
        this.user_name = user_name;
        this.reportContent = reportContent;
        this.imageURL = imageURL;
        this.location = location;
        this.status = status;
        this.startTime = startTime;
        this.maintenanceUserID = maintenanceUserID;
        this.acceptTime = acceptTime;
        this.maintenanceContent = maintenanceContent;
        this.endTime = endTime;
        this.maintenanceUserName = maintenanceUserName;
    }

    public RepairInfoVo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaintenanceSN() {
        return maintenanceSN;
    }

    public void setMaintenanceSN(String maintenanceSN) {
        this.maintenanceSN = maintenanceSN;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
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

    public int getReportUserID() {
        return reportUserID;
    }

    public void setReportUserID(int reportUserID) {
        this.reportUserID = reportUserID;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getMaintenanceUserID() {
        return maintenanceUserID;
    }

    public void setMaintenanceUserID(int maintenanceUserID) {
        this.maintenanceUserID = maintenanceUserID;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getMaintenanceContent() {
        return maintenanceContent;
    }

    public void setMaintenanceContent(String maintenanceContent) {
        this.maintenanceContent = maintenanceContent;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMaintenanceUserName() {
        return maintenanceUserName;
    }

    public void setMaintenanceUserName(String maintenanceUserName) {
        this.maintenanceUserName = maintenanceUserName;
    }

    @Override
    public String toString() {
        return "RepairInfoVo{" +
                "id=" + id +
                ", maintenanceSN='" + maintenanceSN + '\'' +
                ", areaID=" + areaID +
                ", building='" + building + '\'' +
                ", floor='" + floor + '\'' +
                ", equipmentID=" + equipmentID +
                ", equ_name='" + equ_name + '\'' +
                ", equ_style='" + equ_style + '\'' +
                ", reportUserID=" + reportUserID +
                ", user_name='" + user_name + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", location='" + location + '\'' +
                ", status=" + status +
                ", startTime='" + startTime + '\'' +
                ", maintenanceUserID=" + maintenanceUserID +
                ", maintenanceUserName='" + maintenanceUserName + '\'' +
                ", acceptTime='" + acceptTime + '\'' +
                ", maintenanceContent='" + maintenanceContent + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
