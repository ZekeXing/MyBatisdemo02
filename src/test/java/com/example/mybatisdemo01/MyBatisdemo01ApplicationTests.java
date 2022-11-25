package com.example.mybatisdemo01;

import com.example.mybatisdemo01.Dao.ArticleMapper;
import com.example.mybatisdemo01.Dao.CommentMapper307;
import com.example.mybatisdemo01.entity.Article;
import com.example.mybatisdemo01.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisdemo01ApplicationTests {
    @Autowired
    CommentMapper307 commentMapper307;
    @Autowired
    ArticleMapper articleMapper;
    @Test
    void contextLoads() {
       Comment comment = commentMapper307.getCom(2);
        System.out.println(comment);
//        System.out.println("testtttttttt");
    }
    @Test
    void insertTest(){
        Comment comment = new Comment();
        comment.setContent("111");
        comment.setAuthor("znx");
        comment.setAid(1);
        int i = commentMapper307.insertCom(comment);
        System.out.println(i);
    }

    @Test
    void getArticleTest(){
        Article article[] = articleMapper.getArticle();
        for (int i=0;i<article.length;i++) System.out.println(article[i]);


    }

    @Test
    void getArticleAndCommentTest(){
        List<Article> list = articleMapper.getArticleAndComment(1);
        System.out.println(list);

    }
}
