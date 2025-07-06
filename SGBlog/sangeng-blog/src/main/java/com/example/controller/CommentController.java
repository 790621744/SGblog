package com.example.controller;
import com.example.domain.ResponseResult;
import com.example.annotation.SystemLog;
import com.example.constants.SystemConstants;
import com.example.domain.addCommentDto;
import com.example.domain.entity.Comment;
import com.example.service.CommentService;
import com.example.utils.BeanCopyUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 35238
 * @date 2023/7/25 0025 13:14
 */
@Api(tags = "评论的相关接口文档", description = "/commentList/linkCommentList")
@RestController
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    //CommentService是我们在huanf-framework工程写的类
    private CommentService commentService;

    @GetMapping("commentList")
    @ApiOperation(value = "评论列表",notes = "获取评论")
    //ResponseResult是我们在huanf-framework工程写的类
    public ResponseResult commentList(Long articleId,Integer pageNum,Integer pageSize){
        return commentService.commentList(SystemConstants.ARTICLE_COMMENT,articleId,pageNum,pageSize);
    }
//
//    @PostMapping
//    public ResponseResult addComment(@RequestBody Comment comment) {
//        return commentService.addComment(comment);
//
//    }

    @PostMapping
//在文章的评论区发送评论。ResponseResult是我们在huanf-framework工程写的类
    @SystemLog(businessName = "在文章评论区发送评论")//接口描述，用于'日志记录'功能
    public ResponseResult addComment(@RequestBody addCommentDto addCommentDto){
        //把addCommentDto类转换为Comment类类型。BeanCopyUtils是我们在huanf-framework工程写的工具类，可以转换类的类型
        Comment comment = BeanCopyUtils.copyBean(addCommentDto, Comment.class);
        return commentService.addComment(comment);
    }
    @GetMapping("linkCommentList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页号"),
            @ApiImplicitParam(name = "pageSize",value = "每页大小")
    })
    //ResponseResult是我们在huanf-framework工程写的类
    public ResponseResult linkCommentList(Integer pageNum,Integer pageSize){
        return commentService.commentList(SystemConstants.LINK_COMMENT,null,pageNum,pageSize);
    }

}