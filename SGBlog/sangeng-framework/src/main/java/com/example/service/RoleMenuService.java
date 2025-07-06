package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.entity.RoleMenu;
import org.springframework.stereotype.Service;


/**
 * (RoleMenu)表服务接口
 *
 * @author makejava
 * @since 2025-05-25 12:43:58
 */
@Service
public interface RoleMenuService extends IService<RoleMenu> {
    //修改角色-保存修改好的角色信息
    void deleteRoleMenuByRoleId(Long id);
}

