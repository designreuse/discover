package com.ada.plug.controller.admin;

import com.ada.data.utils.FilterUtils;
import com.ada.plug.data.so.PluginConfigSo;
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
import  com.ada.plug.data.entity.PluginConfig;
import com.ada.plug.data.service.PluginConfigService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;

/**
*
* Created by imake on 2017年08月15日11:13:49.
*/


@Scope("prototype")
@Controller
public class PluginConfigAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(PluginConfigAction.class);

	@Autowired
	private PluginConfigService manager;

	@RequiresPermissions("pluginconfig")
	@RequestMapping("/admin/pluginconfig/view_list")
	public String list(Pageable pageable,PluginConfigSo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<PluginConfig> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/pluginconfig/list";
	}

	@RequiresPermissions("pluginconfig")
	@RequestMapping("/admin/pluginconfig/view_add")
	public String add(ModelMap model) {
		return "/admin/pluginconfig/add";
	}

	@RequiresPermissions("pluginconfig")
	@RequestMapping("/admin/pluginconfig/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/pluginconfig/edit";
	}

	@RequiresPermissions("pluginconfig")
	@RequestMapping("/admin/pluginconfig/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/pluginconfig/view";
	}

	@RequiresPermissions("pluginconfig")
	@RequestMapping("/admin/pluginconfig/model_save")
	public String save(PluginConfig bean,ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/pluginconfig/add";
		}
		return view;
	}

	@RequiresPermissions("pluginconfig")
	@RequestMapping("/admin/pluginconfig/model_update")
	public String update(Pageable pageable, PluginConfig bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view="redirect:/admin/pluginconfig/view_list.htm";
		try {
			manager.update(bean);
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/pluginconfig/edit";
		}
		return view;
	}
	@RequiresPermissions("pluginconfig")
	@RequestMapping("/admin/pluginconfig/model_delete")
	public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/pluginconfig/view_list.htm";

		try {
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}

		return view;
	}

	@RequiresPermissions("pluginconfig")
	@RequestMapping("/admin/pluginconfig/model_deletes")
	public String deletes(Pageable pageable, Long[] ids,RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/pluginconfig/view_list.htm";

		try{
				redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
				manager.deleteByIds(ids);
			} catch (DataIntegrityViolationException e) {
				log.error("批量删除失败",e);
				redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
			}
		return view;
	}

}