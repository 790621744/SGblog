package com.example.controller;
import com.example.annotation.SystemLog;
import com.example.domain.ResponseResult;
import com.example.service.ArticleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2025-05-25 13:16:33
 */
@Api(tags = "文章的相关接口文档", description = "")
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//    @GetMapping("/list")
//    public List<Article> test(){
//        return articleService.list();

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
          //查询热门文章 封装成ResponseResult返回
//        ResponseResult result = articleService.hotArticleList();
//        return result;
        return articleService.hotArticleList();
    }
    //分页查询
    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId){
       return articleService.articleList(pageNum,pageSize,categoryId);
    }

    //文章详情
    //先获取文章id
    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id) {
        return articleService.getArticleDetail(id);

    }

    //浏览量递增
    @PutMapping("/updateViewCount/{id}")
    @SystemLog(businessName = "根据文章id从mysql查询文章")//接口描述，用于日志记录功能
    public ResponseResult updateViewCount(@PathVariable("id") Long id){

        return articleService.updateViewCount(id);
    }
}

