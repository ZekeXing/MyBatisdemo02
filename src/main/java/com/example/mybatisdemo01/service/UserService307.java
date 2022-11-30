package com.example.mybatisdemo01.service;

import com.example.mybatisdemo01.Dao.ArticleDao307;
import com.example.mybatisdemo01.Dao.UserDao307;
import com.example.mybatisdemo01.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService307 {
    @Autowired
    UserDao307 dao;

    public String VerifyPW(User user) {

        return dao.selectPwByUsername(user);
    }
}
