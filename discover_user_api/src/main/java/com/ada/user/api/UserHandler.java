package com.ada.user.api;

import com.ada.discover.rest.base.ResponseObject;
import com.ada.user.domain.request.*;
import com.ada.user.domain.response.UserResponse;


/**
 * 用户的一些基本接口
 * <p>
 * Created by ada on 2017/6/29.
 */
public interface UserHandler {


    /**
     * 发送注册码
     *
     * @param request
     * @return
     */
    ResponseObject sendCode(UserCodeRequest request);

    boolean checkCode(String phone, String code, Integer type, ResponseObject result);


    ResponseObject checkPhoneCode(CheckPhoneCodeRequest request);


    /**
     * 通过手机号验证码登陆
     *
     * @param request
     * @return
     */
    UserResponse loginByCode(UserLoginCodeRequest request);


    /**
     * 通过手机号，密码，验证码进行注册
     *
     * @param request
     * @return
     */
    UserResponse registerByCode(UserRegisterCodeRequest request);

    /**
     * 通过手机号密码登陆
     *
     * @param request
     * @return
     */
    UserResponse login(UserLoginRequest request);


    /**
     * 第三方登陆接口，要是登陆成功直接返回用户信息，要是没用绑定需要调用另外一个接口（跳转到绑定页面，调用发送手机验证码功能，然后调用registerOauth接口）
     *
     * @param request
     */
    UserResponse loginOauth(UserLoginOatuthRequest request);

    /**
     * 第三方登陆接口,要是沒有信息，直接注册
     *
     * @param request
     * @return
     */
    UserResponse loginOauthOk(UserLoginOatuthRequest request);


    /**
     * 第三方绑定功能
     *
     * @param request
     * @return
     */
    UserResponse registerOauth(UserRegisterOatuthRequest request);


    /**
     * 用户重置密码
     *
     * @param request
     * @return
     */
    UserResponse resetPassword(UserResetPasswordRequestion request);


    /**
     * 用户更换手机号码
     *
     * @param request
     * @return
     */
    ResponseObject changePhone(UserChangePhoneRequestion request);

    /**
     * 修改用户密码
     *
     * @param request
     * @return
     */
    ResponseObject changePassword(UserChangePasswordRequestion request);


    /**
     * 修改用户密码
     *
     * @param request
     * @return
     */
    UserResponse update(UserUpdateRequestion request);


}
