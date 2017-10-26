package com.ada.plug.data.plugs;

import com.ada.plug.api.SendCodePlugin;
import org.springframework.stereotype.Component;


@Component("noneSendCodePlugin")
public class NoneSendCodePlugin extends SendCodePlugin {
    @Override
    public boolean sendCode(String code, String product, String signName, String template, String phone) {
        return false;
    }

    @Override
    public String getName() {
        return "发送短信例子插件";
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
