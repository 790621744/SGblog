package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.ResponseResult;
import com.example.domain.entity.Link;
import com.example.domain.vo.PageVo;
import org.springframework.stereotype.Service;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2025-05-26 14:22:43
 */
@Service
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();

    //分页查询友链
    PageVo selectLinkPage(Link link, Integer pageNum, Integer pageSize);
}

