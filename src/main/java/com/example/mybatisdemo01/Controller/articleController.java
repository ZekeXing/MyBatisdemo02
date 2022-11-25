package com.example.mybatisdemo01.Controller;

import com.example.mybatisdemo01.Dao.ArticleDao;
import com.example.mybatisdemo01.Dao.ArticleMapper;
import com.example.mybatisdemo01.entity.Article;
import com.example.mybatisdemo01.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class articleController {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleDao articleDao;

    @Autowired
    ArticleService articleService;

    @RequestMapping("/a")
    public String Mybatis(Model model){
        Article article[] = articleMapper.getArticle();
        model.addAttribute("article",article);
        return "index.html";
    }

    @RequestMapping("/b")
    public String index(Model model, @RequestParam(value = "page" ,defaultValue = "1") int page,@RequestParam(value = "count",defaultValue = "2") int count){
//        List<Article> articleList = articleService.getArtilcelist();
//        model.addAttribute("articleList",articleList);
//        System.out.println(articleList);
//        System.out.println(articleList);
        PageHelper.startPage(page,2);
        List<Article> articleList = articleService.getArtilcelist();
        PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);
        model.addAttribute("pageInfo",pageInfo);
        return"index.html";
    }
}
