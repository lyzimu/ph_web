package com.dao.Impl;

import com.bean.Special;
import com.bean.User;
import com.bean.Vet;
import com.dao.UserDao;
import com.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User login(String name, String pwd) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        try {
            return qr.query("select * from t_user where name = ? and pwd = ?", new BeanHandler<User>(User.class), name, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vet> searchVAndS(String vName, String sName) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDs());
        List<Vet> list = new ArrayList<Vet>();
        List<Vet> list2 = new LinkedList<Vet>();
        String sql = "select distinct t_vet.id,t_vet.name from t_vet_speciality " +
                "Inner join t_speciality on (t_vet_speciality.specId = t_speciality.id) " +
                "Inner join t_vet on (t_vet_speciality.vetId = t_vet.id) " +
                "where t_vet.name like concat('%',?,'%') and t_speciality.name like concat('%',?,'%')";
        try {
            list =  qr.query(sql,new BeanListHandler<Vet>(Vet.class),vName,sName);
            for(Vet v:list){
                Vet vet = new Vet();
                vet.setId(v.getId());
                vet.setName(v.getName());
                List<Special> list1 = qr.query("SELECT t_speciality.* FROM t_vet_speciality " +
                        "INNER JOIN t_speciality ON (t_vet_speciality.specId = t_speciality.id)" +
                        "INNER JOIN t_vet ON (t_vet_speciality.vetId = t_vet.id)" +
                        "WHERE t_vet.id = ? and t_speciality.name like concat('%',?,'%')",new BeanListHandler<Special>(Special.class),v.getId(),sName);
                vet.setSpecialList(list1);
                list2.add(vet);
            }
            return list2;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


