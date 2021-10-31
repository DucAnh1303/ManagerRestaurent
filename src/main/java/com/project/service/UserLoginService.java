package com.project.service;

import com.project.common.JWTUtil;
import com.project.model.BaseResponse;
import com.project.model.LoginRequest;
import com.project.model.LoginResponse;
import com.project.model.entity.UserLogin;
import com.project.model.request.UserLoginRequest;
import com.project.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserLoginService {

    @Autowired
    private UserLoginRepository loginRepository;

    public Object register(UserLoginRequest loginRequest){
        List<UserLogin> userLoginList=loginRepository.addUserLogin(
                loginRequest.getUsername(),loginRequest.getPassword()
        );
        if (userLoginList.size()>0){
            return new BaseResponse(400,"SUCCESS");
        }
        else {
            UserLogin userLogin=new UserLogin();
            userLogin.setUsername(loginRequest.getUsername());
            String newPassword=new BCryptPasswordEncoder().encode(loginRequest.getPassword());
            userLogin.setPassword(newPassword);
        userLogin=loginRepository.save(userLogin);
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS",userLogin);
        }
    }


    public BaseResponse login(LoginRequest request){
        List<UserLogin> userLoginList=loginRepository.findByUserName(request.getUsername());
            BCryptPasswordEncoder endcode=new BCryptPasswordEncoder();
            for (UserLogin userLogin:userLoginList){
                if (userLogin.getUsername().equals(request.getUsername())){
                    if (endcode.matches(request.getPassword(),userLogin.getPassword())){
                        BaseResponse res = new BaseResponse();
                        res.setCode(BaseResponse.SUCCESS);
                        res.setMessage("Login success");
                        Map<String, Object> par = new HashMap<>();
                        String token= JWTUtil.getJWT(userLogin.getId() +"",par);
                        LoginResponse re=new LoginResponse(userLogin.getId(),userLogin.getUsername(),token);
                        res.setData(re);
                        return res;
                    }
                }
            }
        return new BaseResponse(BaseResponse.FAIL,"LOGIN FAILS");
    }


}
