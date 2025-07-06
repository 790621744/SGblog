package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.domain.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户 Mapper
 *
 * @author ican
 * @date 2022/12/05 15:28
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {


}