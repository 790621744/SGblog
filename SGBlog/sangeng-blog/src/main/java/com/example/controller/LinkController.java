package com.example.controller;

import com.example.domain.ResponseResult;
import com.example.service.LinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 友链(Link)表控制层
 *
 * @author makejava
 * @since 2025-05-26 14:20:37
 */
@RestController
@RequestMapping("link")
@Api(tags = "友链的相关接口文档", description = "")
public class LinkController {
    /**
     * 服务对象
     */
    @Autowired
    private LinkService linkService;

    @ApiOperation(value = "友链评论列表",notes = "获取友链评论区的评论")
    @GetMapping("/getAllLink")
    public ResponseResult getAllLink(){

        return linkService.getAllLink();
    }



}

