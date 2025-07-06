package com.example.controller;



import com.example.service.ArticleTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ArticleTag)表控制层
 *
 * @author makejava
 * @since 2025-05-25 13:01:04
 */
@RestController
@RequestMapping("articleTag")
public class ArticleTagController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleTagService articleTagService;


}

