package com.qpj.week01.dao;

import com.qpj.week01.been.Rhesis;
import com.qpj.week01.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RhesisDao implements RhesisDaoImpl {
    private final QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    /**
     * @return List
     */
    @Override
    public List<Rhesis> selectAll(){
        String sql = "select rhesis_sentence,rhesis_writer,rhesis_book,inputtime,rhesis_id from rhesis";
        List<Rhesis> query = new ArrayList<>();
        try{
            query = queryRunner.query(DBUtils.getConnection(),sql, new BeanListHandler<Rhesis>(Rhesis.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return query;
    }

//    @Override
//    public boolean login(String username,String  password) {
//        String sql = "select * from user where user_name = ? and user_password = ?";
//        Object[] prams = new Object[]{username,password};
//        try {
//            queryRunner.query(sql,prams);
//        }
//        return false;
//    }
}
