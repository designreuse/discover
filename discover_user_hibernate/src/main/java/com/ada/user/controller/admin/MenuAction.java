package com.ada.user.controller.admin;


import com.ada.data.page.Filter;
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
import  com.ada.user.data.entity.Menu;
import com.ada.user.data.service.MenuService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
* Created by imake on 2017年07月21日14:37:30.
*/
@Controller
public class MenuAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(MenuAction.class);

	@Autowired
	private MenuService manager;

	@RequiresPermissions("menu")
	@RequestMapping("/admin/menu/view_list")
	public String list(Pageable pageable, @RequestParam(value="pid",defaultValue = "1") Integer pid,ModelMap model) {

		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
				pageable.getOrders().add(Order.asc("sortNum"));
			}
			pageable.getFilters().add(Filter.eq("parent.id", pid));
		}
		Page<Menu> pagination = manager.page(pageable);
		List<Menu> tops = manager.findByTops(pid);
		if (tops.size()==0&&pid==1){
			Menu root=new Menu();
			root.setName("根节点");
			root.setLevelInfo(1);
			root.setCode("");
			root.setSortNum(0);
			manager.save(root);
		}
		model.addAttribute("tops",tops);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("pid", pid);
		return "/admin/menu/list";
	}

	@RequiresPermissions("menu")
	@RequestMapping("/admin/menu/view_add")
	public String add(ModelMap model) {
		return "/admin/menu/add";
	}

	@RequiresPermissions("menu")
	@RequestMapping("/admin/menu/view_edit")
	public String edit(Pageable pageable,Integer id,  ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/menu/edit";
	}

	@RequiresPermissions("menu")
	@RequestMapping("/admin/menu/view_view")
	public String view(Integer id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/menu/view";
	}

	@RequiresPermissions("menu")
	@RequestMapping("/admin/menu/model_save")
	public String save(Pageable pageable,Menu bean,RedirectAttributes redirectAttributes,ModelMap model) {
	
	    String view="redirect:/admin/menu/view_list.htm";
		try {
			manager.save(bean);
			redirectAttributes.addAttribute("pid",bean.getParentId());
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/menu/add";
		}
		return view;
	}

	@RequiresPermissions("menu")
	@RequestMapping("/admin/menu/model_update")
	public String update(Pageable pageable, RedirectAttributes redirectAttributes, Menu bean, ModelMap model) {
		
		String view="redirect:/admin/menu/view_list.htm";
		try {
			manager.update(bean);
			redirectAttributes.addAttribute("pid",bean.getParentId());
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/menu/edit";
		}
		return view;
	}
	@RequiresPermissions("menu")
	@RequestMapping("/admin/menu/model_delete")
	public String delete(Pageable pageable, Integer id, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable,1,model);
	}

	@RequiresPermissions("menu")
	@RequestMapping("/admin/menu/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids,ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			log.error("批量删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable,1,model);
	}

}