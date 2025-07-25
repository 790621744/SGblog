package com.example.controller;
import com.example.domain.ResponseResult;
import com.example.domain.entity.Article;
import com.example.domain.vo.ArticleByIdVo;
import com.example.domain.vo.PageVo;
import com.example.dto.AddArticleDto;
import com.example.dto.ArticleDto;
import com.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:21
 */
@RestController
@RequestMapping("/content/article")
public class ArticleController {

    //------------------------------新增博客文章-----------------------------

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article){
        return articleService.add(article);
    }

    //-----------------------------分页查询博客文章---------------------------

    @GetMapping("/list")
    public ResponseResult list(Article article, Integer pageNum, Integer pageSize){
        PageVo pageVo = articleService.selectArticlePage(article,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //---------------------------根据文章id来修改文章--------------------------

    @GetMapping(value = "/{id}")
    //①先查询根据文章id查询对应的文章
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        ArticleByIdVo article = articleService.getInfo(id);
        return ResponseResult.okResult(article);
    }

    @PutMapping
    //②然后才是修改文章
    public ResponseResult edit(@RequestBody ArticleDto article){
        articleService.edit(article);
        return ResponseResult.okResult();
    }

    //---------------------------根据文章id来删除文章-------------------------

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        //直接使用mybatisplus提供的removeById方法
        articleService.removeById(id);
        return ResponseResult.okResult();
    }

    @DeleteMapping
    public ResponseResult remove(@RequestParam(value = "ids")String ids) {
        if (!ids.contains(",")) {
            articleService.removeById(ids);
        } else {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                articleService.removeById(id);
            }
        }
        return ResponseResult.okResult();
    }
}