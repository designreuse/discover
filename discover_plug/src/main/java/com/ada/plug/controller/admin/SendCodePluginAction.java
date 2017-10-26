/*
 * 
 * 
 * 
 */
package com.ada.plug.controller.admin;

import com.ada.plug.data.service.PluginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Controller - 存储插件
 * 
 * 
 * 
 */
@Controller("sendCodePluginController")
@RequestMapping("/admin/sendcode_plugin")
public class SendCodePluginAction {

	@Resource(name = "pluginServiceImpl")
	private PluginService pluginService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("sendCodePlugins", pluginService.getSendCodePlugins());
		return "/admin/sendcode_plugin/list";
	}

}