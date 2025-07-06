package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.entity.Article;
import com.example.domain.vo.ArticleVo;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:13
 */
@Service
public interface ArticleVoMapper extends BaseMapper<ArticleVo> {

}