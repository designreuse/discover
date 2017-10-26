package com.ada.album.controller.admin;

import com.ada.data.utils.FilterUtils;
import com.ada.album.data.so.CategorySo;
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
import  com.ada.album.data.entity.Category;
import com.ada.album.data.service.CategoryService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;

/**
*
* Created by imake on 2017年08月15日10:04:54.
*/


@Scope("prototype")
@Controller
public class CategoryAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(CategoryAction.class);

	@Autowired
	private CategoryService manager;

	@RequiresPermissions("category")
	@RequestMapping("/admin/category/view_list")
	public String list(Pageable pageable,CategorySo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<Category> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/category/list";
	}

	@RequiresPermissions("category")
	@RequestMapping("/admin/category/view_add")
	public String add(ModelMap model) {
		return "/admin/category/add";
	}

	@RequiresPermissions("category")
	@RequestMapping("/admin/category/view_edit")
	public String edit(Pageable pageable,String id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/category/edit";
	}

	@RequiresPermissions("category")
	@RequestMapping("/admin/category/view_view")
	public String view(String id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/category/view";
	}

	@RequiresPermissions("category")
	@RequestMapping("/admin/category/model_save")
	public String save(Category bean,ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/category/add";
		}
		return view;
	}

	@RequiresPermissions("category")
	@RequestMapping("/admin/category/model_update")
	public String update(Pageable pageable, Category bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view="redirect:/admin/category/view_list.htm";
		try {
			manager.update(bean);
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/category/edit";
		}
		return view;
	}
	@RequiresPermissions("category")
	@RequestMapping("/admin/category/model_delete")
	public String delete(Pageable pageable, String id, RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/category/view_list.htm";

		try {
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}

		return view;
	}

	@RequiresPermissions("category")
	@RequestMapping("/admin/category/model_deletes")
	public String deletes(Pageable pageable, String[] ids,RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/category/view_list.htm";

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