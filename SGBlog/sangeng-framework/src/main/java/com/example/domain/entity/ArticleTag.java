package com.example.domain.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章标签关联表(ArticleTag)表实体类
 *
 * @author makejava
 * @since 2025-05-25 15:24:05
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_role")
public class ArticleTag implements Serializable {
    private static final long serialVersionUID = 625337492348897098L;

    /**
     * 文章id
     */
    @TableId
    private Long articleId;
    /**
     * 标签id
     */
    private Long tagId;

}