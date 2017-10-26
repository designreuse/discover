package com.ada.user.controller.admin;

import com.ada.data.utils.FilterUtils;
import com.ada.user.data.so.UserOauthConfigSo;
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
import  com.ada.user.data.entity.UserOauthConfig;
import com.ada.user.data.service.UserOauthConfigService;

/**
* Created by imake on 2017年07月20日17:47:47.
*/
@Controller
public class UserOauthConfigAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(UserOauthConfigAction.class);

	@Autowired
	private UserOauthConfigService manager;

	@RequiresPermissions("useroauthconfig")
	@RequestMapping("/admin/useroauthconfig/view_list")
	public String list(Pageable pageable,UserOauthConfigSo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<UserOauthConfig> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/useroauthconfig/list";
	}

	@RequiresPermissions("useroauthconfig")
	@RequestMapping("/admin/useroauthconfig/view_add")
	public String add(ModelMap model) {
		return "/admin/useroauthconfig/add";
	}

	@RequiresPermissions("useroauthconfig")
	@RequestMapping("/admin/useroauthconfig/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/useroauthconfig/edit";
	}

	@RequiresPermissions("useroauthconfig")
	@RequestMapping("/admin/useroauthconfig/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/useroauthconfig/view";
	}

	@RequiresPermissions("useroauthconfig")
	@RequestMapping("/admin/useroauthconfig/model_save")
	public String save(UserOauthConfig bean,ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/useroauthconfig/add";
		}
		return view;
	}

	@RequiresPermissions("useroauthconfig")
	@RequestMapping("/admin/useroauthconfig/model_update")
	public String update(Pageable pageable, UserOauthConfig bean,ModelMap model) {
		
		String view="redirect:/admin/useroauthconfig/view_list.htm?pageNumber="+pageable.getPageNumber();
		try {
			manager.update(bean);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/useroauthconfig/edit";
		}
		return view;
	}
	@RequiresPermissions("useroauthconfig")
	@RequestMapping("/admin/useroauthconfig/model_delete")
	public String delete(Pageable pageable, Long id, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable,new UserOauthConfigSo(),  model);
	}

	@RequiresPermissions("useroauthconfig")
	@RequestMapping("/admin/useroauthconfig/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			log.error("批量删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable,new UserOauthConfigSo(),  model);
	}

}