package com.qpj.week01.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class RhesisUtil {
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //选择驱动类，连接地址、账号密码，连接mysql
            String url = "";
            String sqlusername="";
            String sqlpassword="";
            conn = DriverManager.getConnection(url, sqlusername,
                    sqlpassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
