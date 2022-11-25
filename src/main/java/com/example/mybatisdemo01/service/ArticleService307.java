package com.example.mybatisdemo01.service;

import com.example.mybatisdemo01.Dao.ArticleDao307;
import com.example.mybatisdemo01.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService307 {

    @Autowired
    ArticleDao307 dao;

    public List<Article> getArtilcelist() {
        return dao.selectByExample();
    }


    public int setFile307(Article article) {
        return dao.setFile(article);
    }
}
