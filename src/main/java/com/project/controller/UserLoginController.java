package com.project.controller;

import com.project.model.BaseResponse;
import com.project.model.LoginRequest;
import com.project.model.request.UserLoginRequest;
import com.project.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    @Autowired
    private UserLoginService loginService;



    @PostMapping("/register")
    public Object register(
            @RequestBody UserLoginRequest loginRequest
    ) {
        return loginService.register(loginRequest);
    }


    @PostMapping("/user/login")
    public BaseResponse login(
            @RequestBody LoginRequest loginRequest
    ) {
        return loginService.login(loginRequest);
    }
}
