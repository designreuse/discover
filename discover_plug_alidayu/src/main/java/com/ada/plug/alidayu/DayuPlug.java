package com.ada.plug.alidayu;

import com.ada.discover.rest.base.ResponseObject;
import com.ada.plug.api.SendCodePlugin;
import com.ada.plug.data.entity.PluginConfig;
import com.tongna.adminstore.AliyunCodePlug;
import com.tongna.adminstore.CodeSendDto;
import org.springframework.stereotype.Component;

@Component("dayuPlug")
public class DayuPlug extends SendCodePlugin {

    @Override
    public boolean sendCode(String code, String product, String signName, String template, String phone) {
        PluginConfig pluginConfig = getPluginConfig();
        if (pluginConfig != null) {
            String appkey = pluginConfig.getAttribute("appkey");
            String secret = pluginConfig.getAttribute("secret");
            String temp = pluginConfig.getAttribute(template);

            AliyunCodePlug plug = new AliyunCodePlug(appkey, secret);
            CodeSendDto dto = new CodeSendDto();
            dto.setCode(code);
            dto.setPhone(phone);
            dto.setProduct(product);
            dto.setSignName(signName);
            dto.setSmsTemplateCode(template);
            ResponseObject vo = plug.send(dto);
        }
        return false;
    }

    @Override
    public String getName() {
        return "阿里大鱼短信插件";
    }

    @Override
    public String getVersion() {
        return "1.01";
    }

    @Override
    public String getAuthor() {
        return "ada.young";
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
