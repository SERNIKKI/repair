package com.qpj.week01.been;

public class AreaInfo {
    private int id;
    private String building;
    private String floor;

    public AreaInfo(int id, String building, String floor) {
        this.id = id;
        this.building = building;
        this.floor = floor;
    }

    public AreaInfo(String building, String floor) {
        this.building = building;
        this.floor = floor;
    }

    public AreaInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "AreaInfo{" +
                "id=" + id +
                ", building='" + building + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
