package com.example.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
//封装
public class HotArticleVo {


    private Long id;
    //标题
    private String title;
    //访问量
    private Long viewCount;
}
