package com.example.controller;

import com.example.domain.ResponseResult;
import com.example.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Category)表控制层
 *
 * @author makejava
 * @since 2025-05-25 13:01:20
 */
@RestController
@RequestMapping("category")
@Api(tags = "分页的相关接口文档", description = "")
public class CategoryController {
    /**
     * 服务对象
     */
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }


}

