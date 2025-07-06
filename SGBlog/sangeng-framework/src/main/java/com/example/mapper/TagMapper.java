package com.example.mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.entity.Tag;
import org.springframework.stereotype.Repository;

/**
 * 标签 Mapper
 *
 * @author ican
 * @date 2022/12/02 22:08
 **/

public interface TagMapper extends BaseMapper<Tag> {
    //删除标签，注意是逻辑删除，所以不能使用mybatisplus提供的，我们要自己使用mybatis写SQL语句
    int myUpdateById(@Param("id") Long id,@Param("flag") int flag);


}