package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户角色 Mapper
 *
 * @author ican
 * @date 2022/12/07 11:09
 **/
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
