package com.example.mybatisdemo01.Controller;

import com.example.mybatisdemo01.Dao.ArticleDao307;
import com.example.mybatisdemo01.Dao.ArticleMapper307;
import com.example.mybatisdemo01.entity.Article;
import com.example.mybatisdemo01.service.ArticleService307;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class articleController307 {
    @Autowired
    ArticleMapper307 articleMapper307;
    @Autowired
    ArticleDao307 articleDao307;

    @Autowired
    ArticleService307 articleService307;

    @RequestMapping("/a")
    public String Mybatis(Model model){
        Article article[] = articleMapper307.getArticle();
        model.addAttribute("article",article);
        return "index307.html";
    }

    @RequestMapping("/b")
    public String index(Model model, @RequestParam(value = "page" ,defaultValue = "1") int page,@RequestParam(value = "count",defaultValue = "2") int count){
//        List<Article> articleList = articleService.getArtilcelist();
//        model.addAttribute("articleList",articleList);
//        System.out.println(articleList);
//        System.out.println(articleList);
        PageHelper.startPage(page,2);
        List<Article> articleList = articleService307.getArtilcelist();
        PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);
        model.addAttribute("pageInfo",pageInfo);
        return"index307.html";
    }
}
