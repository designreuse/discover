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
@Controller("adminStoragePluginController")
@RequestMapping("/admin/storage_plugin")
public class StoragePluginAction {

	@Resource(name = "pluginServiceImpl")
	private PluginService pluginService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("storagePlugins", pluginService.getStoragePlugins());
		return "/admin/storage_plugin/list";
	}

}