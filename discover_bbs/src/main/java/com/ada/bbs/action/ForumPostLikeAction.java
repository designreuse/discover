package com.ada.bbs.action;

import com.ada.data.utils.FilterUtils;
import com.ada.bbs.data.so.ForumPostLikeSo;
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
import  com.ada.bbs.data.entity.ForumPostLike;
import com.ada.bbs.data.service.ForumPostLikeService;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
@Controller
public class ForumPostLikeAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(ForumPostLikeAction.class);

	@Autowired
	private ForumPostLikeService manager;

	@RequiresPermissions("forumpostlike")
	@RequestMapping("/admin/forumpostlike/view_list")
	public String list(Pageable pageable,ForumPostLikeSo so, HttpServletRequest request, ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<ForumPostLike> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/forumpostlike/list";
	}

	@RequiresPermissions("forumpostlike")
	@RequestMapping("/admin/forumpostlike/view_add")
	public String add(ModelMap model) {
		return "/admin/forumpostlike/add";
	}

	@RequiresPermissions("forumpostlike")
	@RequestMapping("/admin/forumpostlike/view_edit")
	public String edit(Pageable pageable,Long id, HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/forumpostlike/edit";
	}

	@RequiresPermissions("forumpostlike")
	@RequestMapping("/admin/forumpostlike/view_view")
	public String view(Long id,HttpServletRequest request, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/forumpostlike/view";
	}

	@RequiresPermissions("forumpostlike")
	@RequestMapping("/admin/forumpostlike/model_save")
	public String save(ForumPostLike bean, HttpServletRequest request, ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/forumpostlike/add";
		}
		return view;
	}

	@RequiresPermissions("forumpostlike")
	@RequestMapping("/admin/forumpostlike/model_update")
	public String update(Pageable pageable, ForumPostLike bean,HttpServletRequest request, ModelMap model) {
		
		String view="redirect:/admin/forumpostlike/view_list.htm?pageNumber="+pageable.getPageNumber();
		try {
			manager.update(bean);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/forumpostlike/edit";
		}
		return view;
	}
	@RequiresPermissions("forumpostlike")
	@RequestMapping("/admin/forumpostlike/model_delete")
	public String delete(Pageable pageable, Long id, HttpServletRequest request, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable,new ForumPostLikeSo(), request, model);
	}

	@RequiresPermissions("forumpostlike")
	@RequestMapping("/admin/forumpostlike/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, HttpServletRequest request, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			log.error("批量删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable,new ForumPostLikeSo(), request, model);
	}

}