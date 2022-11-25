package com.example.mybatisdemo01.Dao;

import com.example.mybatisdemo01.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper307 {

    public Article[] getArticle();


    public List<Article> getArticleAndComment(int aid);



//    List<Article> selectByExample();
}
