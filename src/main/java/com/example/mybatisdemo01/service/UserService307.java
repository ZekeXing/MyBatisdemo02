package com.example.mybatisdemo01.service;

import com.example.mybatisdemo01.Dao.UserDao307;
import org.springframework.stereotype.Service;

@Service
public class UserService307 {
    UserDao307 dao;

    public String VerifyPW(String username) {
       return dao.selectPwByUsername (username);
    }
}
