package com.example.service;

import com.example.domain.ResponseResult;
import com.example.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AdminLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
