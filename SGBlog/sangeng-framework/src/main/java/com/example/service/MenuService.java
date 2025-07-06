package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Menu)表服务接口
 *
 * @author makejava
 * @since 2025-05-25 12:43:48
 */
/**
 /**
 * @author 35238
 * @date 2025/5/25 0004 13:24
 */
@Service
public interface MenuService extends IService<Menu> {
    //查询用户的权限信息
    List<String> selectPermsByUserId(Long id);
    //查询用户的路由信息，也就是查询权限菜单
    List<Menu> selectRouterMenuTreeByUserId(Long userId);

    //查询菜单列表
    List<Menu> selectMenuList(Menu menu);

    //删除菜单-判断是否存在子菜单
    boolean hasChild(Long menuId);

    //修改角色-根据角色id查询对应角色菜单列表树
    List<Long> selectMenuListByRoleId(Long roleId);
}
