package com.service.Impl;

import com.bean.User;
import com.bean.Vet;
import com.dao.Impl.UserDaoImpl;
import com.dao.UserDao;
import com.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();


    @Override
    public User login(String name, String pwd) {
        return dao.login(name,pwd);
    }

    @Override
    public List<Vet> searchVet(String vName, String sName) {
        return dao.searchVAndS(vName,sName);
    }
}
