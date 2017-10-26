package com.ada.user.controller.admin;

import com.ada.data.utils.FilterUtils;
import com.ada.user.data.so.UserOauthTokenSo;
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
import  com.ada.user.data.entity.UserOauthToken;
import com.ada.user.data.service.UserOauthTokenService;

/**
* Created by imake on 2017年07月21日16:04:29.
*/
@Controller
public class UserOauthTokenAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(UserOauthTokenAction.class);

	@Autowired
	private UserOauthTokenService manager;

	@RequiresPermissions("useroauthtoken")
	@RequestMapping("/admin/useroauthtoken/view_list")
	public String list(Pageable pageable,UserOauthTokenSo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<UserOauthToken> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/useroauthtoken/list";
	}

	@RequiresPermissions("useroauthtoken")
	@RequestMapping("/admin/useroauthtoken/view_add")
	public String add(ModelMap model) {
		return "/admin/useroauthtoken/add";
	}

	@RequiresPermissions("useroauthtoken")
	@RequestMapping("/admin/useroauthtoken/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/useroauthtoken/edit";
	}

	@RequiresPermissions("useroauthtoken")
	@RequestMapping("/admin/useroauthtoken/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/useroauthtoken/view";
	}

	@RequiresPermissions("useroauthtoken")
	@RequestMapping("/admin/useroauthtoken/model_save")
	public String save(UserOauthToken bean,ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/useroauthtoken/add";
		}
		return view;
	}

	@RequiresPermissions("useroauthtoken")
	@RequestMapping("/admin/useroauthtoken/model_update")
	public String update(Pageable pageable, UserOauthToken bean,ModelMap model) {
		
		String view="redirect:/admin/useroauthtoken/view_list.htm?pageNumber="+pageable.getPageNumber();
		try {
			manager.update(bean);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/useroauthtoken/edit";
		}
		return view;
	}
	@RequiresPermissions("useroauthtoken")
	@RequestMapping("/admin/useroauthtoken/model_delete")
	public String delete(Pageable pageable, Long id, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable,new UserOauthTokenSo(),  model);
	}

	@RequiresPermissions("useroauthtoken")
	@RequestMapping("/admin/useroauthtoken/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			log.error("批量删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable,new UserOauthTokenSo(),  model);
	}

}