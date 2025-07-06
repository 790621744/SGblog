package com.example.controller;



import com.example.annotation.SystemLog;
import com.example.domain.ResponseResult;
import com.example.domain.entity.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2025-05-25 13:02:44
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户的相关接口文档", description = "")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @GetMapping("/userInfo")
    @SystemLog(businessName = "更新用户信息")
    public ResponseResult userInfo(){
        return userService.userInfo();
    }


    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }

}

