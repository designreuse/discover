package com.baidubce.services.lss.model;

/**
 * Created by wuyafei on 16/6/28.
 */
public class PublishPrefix {
    private String push;

    public String getPush() {
        return push;
    }

    public void setPush(String push) {
        this.push = push;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class PublishPrefix {\n");
        sb.append("    pushUrlPrefix: ").append(push).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
