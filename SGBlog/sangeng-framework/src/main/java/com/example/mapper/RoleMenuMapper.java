package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色菜单 Mapper
 *
 * @author ican
 * @date 2022/12/07 11:16
 **/
@Repository
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

}