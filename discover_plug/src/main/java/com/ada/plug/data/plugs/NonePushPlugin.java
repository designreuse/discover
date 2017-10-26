package com.ada.plug.data.plugs;

import com.ada.plug.api.PushPlugin;
import com.ada.plug.data.vo.PushBack;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component("nonePushPlugin")
public class NonePushPlugin extends PushPlugin {
    @Override
    public PushBack pushAll(String msg, Map<String, String> keys) {
        return null;
    }

    @Override
    public PushBack pushToSingleDevice(String chanel, String msg, Map<String, String> keys) {
        return null;
    }

    @Override
    public PushBack pushToTag(String tag, String msg, Map<String, String> keys) {
        return null;
    }

    @Override
    public PushBack pushToChannels(String[] chanels, String msg, Map<String, String> keys) {
        return null;
    }

    @Override
    public String getName() {
        return "推送例子插件";
    }

    @Override
    public String getVersion() {
        return "1.01";
    }

    @Override
    public String getAuthor() {
        return "ada.young";
    }

    public boolean getIsInstalled() {
        return false;
    }

    @Override
    public String getSiteUrl() {
        return null;
    }

    @Override
    public String getInstallUrl() {
        return null;
    }

    @Override
    public String getUninstallUrl() {
        return null;
    }

    @Override
    public String getSettingUrl() {
        return null;
    }
}
