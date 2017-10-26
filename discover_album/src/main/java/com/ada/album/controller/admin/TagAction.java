package com.ada.album.controller.admin;

import com.ada.data.utils.FilterUtils;
import com.ada.album.data.so.TagSo;
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
import  com.ada.album.data.entity.Tag;
import com.ada.album.data.service.TagService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;

/**
*
* Created by imake on 2017年08月15日10:04:55.
*/


@Scope("prototype")
@Controller
public class TagAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(TagAction.class);

	@Autowired
	private TagService manager;

	@RequiresPermissions("tag")
	@RequestMapping("/admin/tag/view_list")
	public String list(Pageable pageable,TagSo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<Tag> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/tag/list";
	}

	@RequiresPermissions("tag")
	@RequestMapping("/admin/tag/view_add")
	public String add(ModelMap model) {
		return "/admin/tag/add";
	}

	@RequiresPermissions("tag")
	@RequestMapping("/admin/tag/view_edit")
	public String edit(Pageable pageable,String id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/tag/edit";
	}

	@RequiresPermissions("tag")
	@RequestMapping("/admin/tag/view_view")
	public String view(String id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/tag/view";
	}

	@RequiresPermissions("tag")
	@RequestMapping("/admin/tag/model_save")
	public String save(Tag bean,ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getName());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/tag/add";
		}
		return view;
	}

	@RequiresPermissions("tag")
	@RequestMapping("/admin/tag/model_update")
	public String update(Pageable pageable, Tag bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view="redirect:/admin/tag/view_list.htm";
		try {
			manager.update(bean);
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/tag/edit";
		}
		return view;
	}
	@RequiresPermissions("tag")
	@RequestMapping("/admin/tag/model_delete")
	public String delete(Pageable pageable, String id, RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/tag/view_list.htm";

		try {
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}

		return view;
	}

	@RequiresPermissions("tag")
	@RequestMapping("/admin/tag/model_deletes")
	public String deletes(Pageable pageable, String[] ids,RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/tag/view_list.htm";

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