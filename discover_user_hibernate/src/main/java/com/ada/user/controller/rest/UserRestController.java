package com.ada.user.controller.rest;

import com.ada.discover.rest.base.ResponseObject;
import com.ada.user.api.UserHandler;
import com.ada.user.domain.request.*;
import com.ada.user.domain.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Created by ada on 2017/6/29.
 */


@RestController
@RequestMapping(value = "rest")
public class UserRestController {



    @RequestMapping(value = "/user/sendCode")
    public ResponseObject sendCode(UserCodeRequest request) {
        return userHandler.sendCode(request);
    }

    @RequestMapping(value = "/user/loginByCode")
    public UserResponse loginByCode(UserLoginCodeRequest request) {
        return userHandler.loginByCode(request);
    }


    @RequestMapping(value = "/user/login")
    public UserResponse login(UserLoginRequest request) {
        return userHandler.login(request);
    }

    @RequestMapping(value = "/user/loginOauth")
    public UserResponse loginOauth(UserLoginOatuthRequest request) {
        return userHandler.loginOauth(request);
    }

    @RequestMapping(value = "/user/registerOauth")
    public UserResponse registerOauth(UserRegisterOatuthRequest request) {
        return userHandler.registerOauth(request);
    }

    @RequestMapping(value = "/user/registerByCode")
    public UserResponse registerByCode(UserRegisterCodeRequest request) {
        return userHandler.registerByCode(request);
    }


    @RequestMapping(value = "/user/resetPassword")
    public UserResponse resetPassword(UserResetPasswordRequestion request) {
        return userHandler.resetPassword(request);
    }


    @RequestMapping(value = "/user/changePhone")
    public ResponseObject changePhone(UserChangePhoneRequestion request) {
        return userHandler.changePhone(request);
    }

    @RequestMapping(value = "/user/changePassword")
    public ResponseObject changePassword(UserChangePasswordRequestion request) {
        return userHandler.changePassword(request);
    }


    @RequestMapping(value = "/user/update")
    public ResponseObject update(UserUpdateRequestion request) {
        return userHandler.update(request);
    }


    @RequestMapping(value = "/user/checkPhoneCode")
    public ResponseObject checkPhoneCode(CheckPhoneCodeRequest request) {
        return userHandler.checkPhoneCode(request);
    }

    @Autowired
    UserHandler userHandler;

}
