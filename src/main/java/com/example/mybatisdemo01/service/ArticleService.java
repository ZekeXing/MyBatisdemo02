package com.example.mybatisdemo01.service;

import com.example.mybatisdemo01.Dao.ArticleDao;
import com.example.mybatisdemo01.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleDao dao;

    public List<Article> getArtilcelist() {
        return dao.selectByExample();
    }
}
