package com.example.mybatisdemo01.Controller;

import com.example.mybatisdemo01.Dao.ArticleDao307;
import com.example.mybatisdemo01.Dao.ArticleMapper307;
import com.example.mybatisdemo01.Dao.UserDao307;
import com.example.mybatisdemo01.entity.Article;
import com.example.mybatisdemo01.entity.User;
import com.example.mybatisdemo01.service.ArticleService307;
import com.example.mybatisdemo01.service.UserService307;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
public class articleController307 {
    @Autowired
    ArticleMapper307 articleMapper307;
    @Autowired
    ArticleDao307 articleDao307;
@Autowired
    UserService307 userService307;

    @Autowired
    ArticleService307 articleService307;

    @RequestMapping("/toLogin307")
    public String toLogin(Model model) {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login/login307";
    }

    @RequestMapping(value="/login")
    public String login(User user, Model model, HttpSession session) {
        // 获取用户名和密码
        String username = user.getName();
        String password = user.getPassword();
        String VPW = userService307.VerifyPW(user);
        System.out.println(VPW);
        if(username != null && password != null && password.equals(VPW)){
            // 将用户对象添加到Session
            session.setAttribute("USER_SESSION", user);
            // 跳转到登录成功页面
            return "forward:main307";
        }
        //登录信息验证失败，进行错误提示
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "forward:toLogin307";
    }


    @RequestMapping("/main307")
    public String Mybatis(Model model) {
        Article article[] = articleMapper307.getArticle();
        model.addAttribute("article", article);
        return "index307.html";
    }

    @RequestMapping("/b")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "count", defaultValue = "2") int count) {
//        List<Article> articleList = articleService.getArtilcelist();
//        model.addAttribute("articleList",articleList);
//        System.out.println(articleList);
//        System.out.println(articleList);
        PageHelper.startPage(page, 2);
        List<Article> articleList = articleService307.getArtilcelist();
        PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);
        model.addAttribute("pageInfo", pageInfo);
        return "index307.html";
    }

    @RequestMapping("/fileUp307")
    public String fileUpload(String title, List<MultipartFile> uploadfile, HttpServletRequest request, Model model, Integer aid) {

        String fullName = title;
        // 判断所上传文件是否存在
        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
            //循环输出上传的文件
            for (MultipartFile file : uploadfile) {
                // 获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                // 设置上传文件的保存地址目录
                String dirPath = "D:/Java/BigThree/MyBatisdemo02/src/main/resources/static/images/";
                File filePath = new File(dirPath);
                System.out.println("=========dirPath=" + dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                // 使用UUID（通用唯一标识）重新命名上传的文件名称(上传人_uuid_原始文件名称)
                String newFilename = UUID.randomUUID() + "_" + originalFilename;
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(dirPath + newFilename));
                    fullName = newFilename;
                    request.setAttribute("fileurl", "/public/" + newFilename);
                    model.addAttribute("fileurl", "/public/" + newFilename);
                    System.out.println(model);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            // 获取article属性
            Article article = new Article();
            article.setAid(aid);
            article.setTitle(title);
            article.setTitlepic(fullName);

            // 跳转到成功页面
            int i = articleService307.setFile307(article);
            return "redirect:/main307";
        } else {
            return "error";
        }
    }

    // 所有类型文件下载管理
    @GetMapping("/fileDown307")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,
                                               String filename) throws Exception {
//        System.out.println(filename);
        // 指定要下载的文件根路径
        String dirPath = "D:\\Java\\BigThree\\MyBatisdemo02\\src\\main\\resources\\static\\images";
        // 创建该文件对象
        File file = new File(dirPath + File.separator + filename);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以下载方式打开（下载前对文件名进行转码）
        filename = getFilename(request, filename);
        headers.setContentDispositionFormData("attachment", filename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    // 根据浏览器的不同进行编码设置，返回编码后的文件名
    private String getFilename(HttpServletRequest request, String filename)
            throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为UTF-8编码显示，并对转换的+进行更正
                return URLEncoder.encode(filename, "UTF-8").replace("+", " ");
            }
        }
        //火狐等其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }
}




