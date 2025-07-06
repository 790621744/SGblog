package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.ResponseResult;
import com.example.domain.entity.Category;
import com.example.domain.vo.CategoryVo;
import com.example.domain.vo.PageVo;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Category)表服务接口
 *
 * @author makejava
 * @since 2025-05-25 12:43:36
 */
@Service
public interface CategoryService extends IService<Category> {

    //查询文章分类的接口
    ResponseResult getCategoryList();

    //写博客-查询文章分类的接口
    List<CategoryVo> listAllCategory();

    //分页查询分类列表
    PageVo selectCategoryPage(Category category, Integer pageNum, Integer pageSize);
}

