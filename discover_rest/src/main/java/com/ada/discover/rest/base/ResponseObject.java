package com.ada.discover.rest.base;

import java.io.Serializable;

/**
 * Created by ada on 2017/5/16.
 */
public class ResponseObject implements Serializable{

    private String msg="成功";

    private int code=0;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
