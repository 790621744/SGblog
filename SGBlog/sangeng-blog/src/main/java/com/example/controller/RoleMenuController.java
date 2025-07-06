package com.example.controller;
import com.example.service.RoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RoleMenu)表控制层
 *
 * @author makejava
 * @since 2025-05-25 13:02:11
 */
@RestController
@RequestMapping("roleMenu")
public class RoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private RoleMenuService roleMenuService;


}

