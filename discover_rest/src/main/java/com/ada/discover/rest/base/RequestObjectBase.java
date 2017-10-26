package com.ada.discover.rest.base;

/**
 * Created by ada on 2017/5/16.
 */
public class RequestObjectBase implements RequestObject {

    /**
     * 盐
     */
    private String salt;

    /**
     * 时间戳
     */
    private Long time;


    /**
     * 参数签名
     */
    private String sign;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public long time() {
        return time;
    }

    @Override
    public String salt() {
        return salt;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
