package com.dao;

import com.bean.User;
import com.bean.Vet;

import java.util.List;

public interface UserDao {


    User login(String name, String pwd);

    List<Vet> searchVAndS(String vName, String sName);
}
