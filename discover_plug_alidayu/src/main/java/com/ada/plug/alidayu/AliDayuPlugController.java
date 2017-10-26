/*
 * 
 * 
 * 
 */
package com.ada.plug.alidayu;

import com.ada.discover.rest.base.ResponseObject;
import com.ada.plug.data.entity.PluginConfig;
import com.ada.plug.data.service.PluginConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Controller - 支付宝(双接口)
 */
@Controller("aliDayuPlugController")
@RequestMapping("/admin/sendcode_plugin/alidayu")
public class AliDayuPlugController {

    @Resource(name = "dayuPlug")
    private DayuPlug dayuPlug;

    @Resource(name = "pluginConfigServiceImpl")
    private PluginConfigService pluginConfigService;

    /**
     * 安装
     */
    @RequestMapping(value = "/install", method = RequestMethod.POST)
    public @ResponseBody
    ResponseObject install() {
        if (!dayuPlug.getIsInstalled()) {
            PluginConfig pluginConfig = new PluginConfig();
            pluginConfig.setPluginId(dayuPlug.getId());
            pluginConfig.setIsEnabled(false);
            pluginConfigService.save(pluginConfig);
        }
        return new ResponseObject();
    }

    /**
     * 卸载
     */
    @RequestMapping(value = "/uninstall", method = RequestMethod.POST)
    public @ResponseBody
    ResponseObject uninstall() {
        if (dayuPlug.getIsInstalled()) {
            PluginConfig pluginConfig = dayuPlug.getPluginConfig();
            pluginConfigService.deleteById(pluginConfig.getId());
        }
        return new ResponseObject();
    }

    /**
     * 设置
     */
    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String setting(ModelMap model) {
        PluginConfig pluginConfig = dayuPlug.getPluginConfig();
        model.addAttribute("feeTypes", pluginConfig.getAttributes());
        model.addAttribute("pluginConfig", pluginConfig);
        return "/admin/sendcode_plugin/alidayusetting";
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(String appkey, String secret,Boolean isEnabled) {
        PluginConfig pluginConfig = dayuPlug.getPluginConfig();
        pluginConfig.setAttribute("appkey", appkey);
        pluginConfig.setAttribute("secret", secret);
        pluginConfig.setIsEnabled(isEnabled);
        pluginConfigService.update(pluginConfig);
        //addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
        return "redirect:/admin/sendcode_plugin/list.htm";
    }

}