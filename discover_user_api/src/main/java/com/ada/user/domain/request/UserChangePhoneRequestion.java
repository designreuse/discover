package com.ada.user.domain.request;

/**
 * Created by ada on 2017/7/4.
 */
public class UserChangePhoneRequestion extends UserTokenRequest {

    /**
     * 手机验证码
     */
    String code;


    /**
     * 新的手机号码
     */
    String phone;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
