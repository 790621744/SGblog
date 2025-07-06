package com.example.runner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.domain.entity.Article;
import com.example.mapper.ArticleMapper;
import com.example.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Component
//public class ViewCountRunner implements CommandLineRunner {
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("程序初始化");
//    }
//}

@Component
public class ViewCountRunner implements CommandLineRunner{

        @Autowired
        private ArticleMapper articleMapper;

        @Autowired
        private RedisCache redisCache;

        @Override
        public void run(String... args) throws Exception {
            // 只查询 id 和 viewCount 字段
            LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.select(Article::getId, Article::getViewCount);
            List<Article> articles = articleMapper.selectList(queryWrapper);

            // 转换为 Map<String, Integer>
            Map<String, Integer> viewCountMap = articles.stream()
                    .collect(Collectors.toMap(
                            article -> article.getId().toString(),
                            article -> article.getViewCount().intValue()
                    ));

            // 存入 Redis
            redisCache.setCacheMap("article:viewCount", viewCountMap);

            System.out.println("文章浏览量缓存初始化完成，共计：" + viewCountMap.size() + " 条记录");
        }
}

    //@Override
    ////下面的写法是stream流+函数式编程
    //public void run(String... args) throws Exception {
    //    //查询数据库中的博客信息，注意只需要查询id、viewCount字段的博客信息
    //    List<Article> articles = articleMapper.selectList(null);//为null即无条件，表示查询所有
    //    articles.stream()
    //            //由于我们需要key、value的数据，所有可以通过stream流，转为map集合。new Function表示函数式编程
    //            .collect(Collectors.toMap(new Function<Article, Long>() {
    //                @Override
    //                public Long apply(Article article) {
    //                    return article.getId();
    //                }
    //            }, new Function<Article, Integer>() {//new Function表示函数式编程
    //                @Override
    //                public Integer apply(Article article) {
    //                    return article.getViewCount().intValue();
    //                }
    //            }));
