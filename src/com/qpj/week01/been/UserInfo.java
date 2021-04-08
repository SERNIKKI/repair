package com.qpj.week01.been;

public class UserInfo {
    private int id;
    private String user_name;
    private String user_password;
    private String token;
    private int roleID;
    private String role_name;

    public UserInfo(int id, String user_name, String user_password) {
        this.id = id;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public UserInfo(String user_name, String user_password) {
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public UserInfo(int id, String user_name, String user_password, int roleID) {
        this.id = id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.roleID = roleID;
    }

    public UserInfo(int id, String user_name, String user_password, int roleID, String role_name) {
        this.id = id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.roleID = roleID;
        this.role_name = role_name;
    }

    public UserInfo(int id, String user_name, String user_password, String role_name) {
        this.id = id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.role_name = role_name;
    }

    public UserInfo() {
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", token='" + token + '\'' +
                ", roleID=" + roleID +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
