package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.ResponseResult;
import com.example.domain.entity.Comment;
import org.springframework.stereotype.Service;


/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2025-05-25 12:43:43
 */
@Service
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}

