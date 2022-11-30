package com.example.mybatisdemo01;

import com.example.mybatisdemo01.Dao.ArticleMapper307;
import com.example.mybatisdemo01.Dao.CommentMapper307;
import com.example.mybatisdemo01.Dao.UserDao307;
import com.example.mybatisdemo01.entity.Article;
import com.example.mybatisdemo01.entity.Comment;
import com.example.mybatisdemo01.entity.User;
import com.example.mybatisdemo01.service.ArticleService307;
import com.example.mybatisdemo01.service.UserService307;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisdemo01ApplicationTests {
    @Autowired
    CommentMapper307 commentMapper307;
    @Autowired
    ArticleMapper307 articleMapper307;
    @Autowired
    ArticleService307 articleService307;
    @Autowired
    UserService307 userService307;
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
        Article article[] = articleMapper307.getArticle();
        for (int i=0;i<article.length;i++) System.out.println(article[i]);


    }

    @Test
    void getArticleAndCommentTest(){
        List<Article> list = articleMapper307.getArticleAndComment(1);
        System.out.println(list);

    }
    @Test
    void getPasswordTest(){
        User user =new User();
        user.setName("123123213");
        System.out.println(user);
        System.out.println(userService307.VerifyPW(user));
    }
}
