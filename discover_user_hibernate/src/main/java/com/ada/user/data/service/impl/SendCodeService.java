package com.ada.user.data.service.impl;

import com.ada.plug.api.SendCodePlugin;
import com.ada.plug.data.service.PluginService;
import com.ada.user.api.SendCodeApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SendCodeService implements SendCodeApi {


    @Resource(name = "pluginServiceImpl")
    private PluginService pluginService;

    @Override
    public boolean sendCode(String code, String product, String signName, String template, String phone) {

        for (SendCodePlugin storagePlugin : pluginService.getSendCodePlugins(true)) {
            return storagePlugin.sendCode(code,product,signName,template,phone);
        }
        return false;
    }
}
