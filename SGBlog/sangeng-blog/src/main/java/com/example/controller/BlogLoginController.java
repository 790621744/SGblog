package com.example.controller;

import com.example.domain.ResponseResult;
import com.example.domain.entity.User;
import com.example.enums.AppHttpCodeEnum;
import com.example.exception.SystemException;
import com.example.service.BlogLoginService;
import io.swagger.annotations.Api;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//BlogLoginController → 抛出 → SystemException → 被 → GlobalExceptionHandler 捕获

//前端请求 → BlogLoginController.login()
//                  ↓
//userName为空 → throw new SystemException(...)
//                  ↓
//GlobalExceptionHandler 捕获该异常
//                  ↓
//返回统一的错误响应 ResponseResult



/**
 * @author 35238
 * @date 2023/7/22 0022 21:31
 */
@Api(tags = "登录登出的相关接口文档", description = "")
@RestController
public class BlogLoginController {

    @Autowired
    //BlogLoginService是我们在service目录写的接口
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    //ResponseResult是我们在huanf-framework工程里面写的实体类
    public ResponseResult login(@RequestBody User user){
        //如果用户在进行登录时，没有传入'用户名'
        if(!StringUtils.hasText(user.getUserName())){
            // 提示'必须要传用户名'。AppHttpCodeEnum是我们写的枚举类。SystemException是我们写的统一异常处理的类
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }
}