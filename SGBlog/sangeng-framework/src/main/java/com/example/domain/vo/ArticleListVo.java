package com.example.domain.vo;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleListVo {
    @TableId
    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;
    //所属分类id
    private String categoryName;
    //缩略图
    private String thumbnail;
    //访问量
    private Long viewCount;

    private Date createTime;

}
