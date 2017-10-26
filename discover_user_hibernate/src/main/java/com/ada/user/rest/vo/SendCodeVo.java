package com.ada.user.rest.vo;

import com.ada.discover.rest.base.ResponseObject;

/**
 * Created by ada on 2017/6/30.
 */
public class SendCodeVo extends ResponseObject {

    private String sendCode;

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }
}
