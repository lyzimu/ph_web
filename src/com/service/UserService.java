package com.service;

import com.bean.User;
import com.bean.Vet;

import java.util.List;

public interface UserService {
    User login(String name, String pwd);

    List<Vet> searchVet(String vName, String sName);
}
