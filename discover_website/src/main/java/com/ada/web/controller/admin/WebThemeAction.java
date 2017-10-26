package com.ada.web.controller.admin;

import com.ada.data.utils.FilterUtils;
import com.ada.web.data.so.WebThemeSo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import  com.ada.web.data.entity.WebTheme;
import com.ada.web.data.service.WebThemeService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;

/**
*
* Created by imake on 2017年08月30日10:13:36.
*/


@Scope("prototype")
@Controller
public class WebThemeAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(WebThemeAction.class);

	@Autowired
	private WebThemeService manager;

	@RequiresPermissions("webtheme")
	@RequestMapping("/admin/webtheme/view_list")
	public String list(Pageable pageable,WebThemeSo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<WebTheme> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/webtheme/list";
	}


	@RequiresPermissions("webtheme")
	@RequestMapping("/admin/webtheme/view_edit")
	public String edit(Pageable pageable,String id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/webtheme/edit";
	}


	@RequiresPermissions("webtheme")
	@RequestMapping("/admin/webtheme/model_update")
	public String update(Pageable pageable, WebTheme bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view="redirect:/admin/webtheme/view_list.htm";
		try {
			manager.update(bean);
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/webtheme/edit";
		}
		return view;
	}


}