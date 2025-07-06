package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.domain.vo.ArticleVo;
import com.example.mapper.ArticleVoMapper;
import com.example.service.ArticleVoService;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/8/9 0009 21:20
 */
@Service
public class ArticleVoServiceImpl extends ServiceImpl<ArticleVoMapper, ArticleVo> implements ArticleVoService {

}