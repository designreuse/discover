package com.ada.bbs.action;


import com.ada.data.page.Filter;
import javax.servlet.http.HttpServletRequest;
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
import  com.ada.bbs.data.entity.Forum;
import com.ada.bbs.data.service.ForumService;
import org.springframework.web.bind.annotation.RequestParam;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
@Controller
public class ForumAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(ForumAction.class);

	@Autowired
	private ForumService manager;

	@RequiresPermissions("forum")
	@RequestMapping("/admin/forum/view_list")
	public String list(Pageable pageable, @RequestParam(value="pid",defaultValue = "1") Integer pid, HttpServletRequest request, ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
				pageable.getOrders().add(Order.asc("code"));
			}
			pageable.getFilters().add(Filter.eq("parent.id", pid));
		}
		Page<Forum> pagination = manager.page(pageable);
		model.addAttribute("tops", manager.findByTops(pid));
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("pid", pid);
		return "/admin/forum/list";
	}

	@RequiresPermissions("forum")
	@RequestMapping("/admin/forum/view_add")
	public String add(ModelMap model) {
		return "/admin/forum/add";
	}

	@RequiresPermissions("forum")
	@RequestMapping("/admin/forum/view_edit")
	public String edit(Pageable pageable,Integer id, HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/forum/edit";
	}

	@RequiresPermissions("forum")
	@RequestMapping("/admin/forum/view_view")
	public String view(Integer id,HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/forum/view";
	}

	@RequiresPermissions("forum")
	@RequestMapping("/admin/forum/model_save")
	public String save(Pageable pageable,Forum bean, HttpServletRequest request, ModelMap model) {
	
	    String view="redirect:/admin/forum/view_list.htm?pid=" + bean.getParentId() + "&pageNumber=" + pageable.getPageNumber();
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/forum/add";
		}
		return view;
	}

	@RequiresPermissions("forum")
	@RequestMapping("/admin/forum/model_update")
	public String update(Pageable pageable, Forum bean,HttpServletRequest request, ModelMap model) {
		
		String view="redirect:/admin/forum/view_list.htm?pid=" + bean.getParentId() + "&pageNumber=" + pageable.getPageNumber();
		try {
			manager.update(bean);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/forum/edit";
		}
		return view;
	}
	@RequiresPermissions("forum")
	@RequestMapping("/admin/forum/model_delete")
	public String delete(Pageable pageable, Integer id, HttpServletRequest request, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable,1, request, model);
	}

	@RequiresPermissions("forum")
	@RequestMapping("/admin/forum/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids, HttpServletRequest request, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			log.error("批量删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable,1, request, model);
	}

}