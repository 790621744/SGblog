package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.entity.Article;

import org.springframework.stereotype.Repository;

/**
 * 文章 Mapper
 *
 * @author ican
 * @date 2022/12/04 22:29
 **/
@Repository
public interface ArticleMapper extends BaseMapper<Article> {


}