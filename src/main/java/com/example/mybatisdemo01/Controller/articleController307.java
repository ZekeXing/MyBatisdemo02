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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping("/fileUp307/{aid}")
    public String fileUpload(String title, List<MultipartFile> uploadfile, HttpServletRequest request, Model model,@PathVariable("aid") Integer aid) {
        System.out.println(title);
        System.out.println(uploadfile);
        System.out.println(request);
        System.out.println(aid);
//        // 判断所上传文件是否存在
//        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
//            //循环输出上传的文件
//            for (MultipartFile file : uploadfile) {
//                // 获取上传文件的原始名称
//                String originalFilename = file.getOriginalFilename();
//                // 设置上传文件的保存地址目录
////                String dirPath = request.getServletContext().getRealPath("/public/");
////                String dirPath = request.getServletContext().getRealPath("D:/Java/BigThree/fileUploadDown/src/main/resources/files");
//                String dirPath ="D:/Java/BigThree/fileUploadDown/src/main/resources/files/";
//                File filePath = new File(dirPath);
//                System.out.println("=========dirPath="+dirPath);
//                // 如果保存文件的地址不存在，就先创建目录
//                if (!filePath.exists()) {
//                    filePath.mkdirs();
//                }
//                // 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
//                String newFilename = UUID.randomUUID()+"_"+originalFilename;
//                try {
//                    // 使用MultipartFile接口的方法完成文件上传到指定位置
//                    file.transferTo(new File(dirPath + newFilename));
//
//                    request.setAttribute("fileurl","/public/"+ newFilename);
//                    model.addAttribute("fileurl","/public/"+ newFilename);
//                    System.out.println(model);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return"error";
//                }
//            }
//            // 跳转到成功页面
//            return "success";
//        }else{
//            return"error";
//        }
        return null;
    }



}
