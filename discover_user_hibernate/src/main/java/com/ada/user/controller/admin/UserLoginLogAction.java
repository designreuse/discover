package com.ada.user.controller.admin;

import com.ada.data.utils.FilterUtils;
import com.ada.user.data.so.UserLoginLogSo;
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
import  com.ada.user.data.entity.UserLoginLog;
import com.ada.user.data.service.UserLoginLogService;

/**
* Created by imake on 2017年07月21日15:55:37.
*/
@Controller
public class UserLoginLogAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(UserLoginLogAction.class);

	@Autowired
	private UserLoginLogService manager;

	@RequiresPermissions("userloginlog")
	@RequestMapping("/admin/userloginlog/view_list")
	public String list(Pageable pageable,UserLoginLogSo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<UserLoginLog> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/userloginlog/list";
	}

	@RequiresPermissions("userloginlog")
	@RequestMapping("/admin/userloginlog/view_add")
	public String add(ModelMap model) {
		return "/admin/userloginlog/add";
	}

	@RequiresPermissions("userloginlog")
	@RequestMapping("/admin/userloginlog/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/userloginlog/edit";
	}

	@RequiresPermissions("userloginlog")
	@RequestMapping("/admin/userloginlog/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/userloginlog/view";
	}

	@RequiresPermissions("userloginlog")
	@RequestMapping("/admin/userloginlog/model_save")
	public String save(UserLoginLog bean,ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/userloginlog/add";
		}
		return view;
	}

	@RequiresPermissions("userloginlog")
	@RequestMapping("/admin/userloginlog/model_update")
	public String update(Pageable pageable, UserLoginLog bean,ModelMap model) {
		
		String view="redirect:/admin/userloginlog/view_list.htm?pageNumber="+pageable.getPageNumber();
		try {
			manager.update(bean);
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/userloginlog/edit";
		}
		return view;
	}
	@RequiresPermissions("userloginlog")
	@RequestMapping("/admin/userloginlog/model_delete")
	public String delete(Pageable pageable, Long id, ModelMap model) {
			 
		try {
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
					 
		return list(pageable,new UserLoginLogSo(),  model);
	}

	@RequiresPermissions("userloginlog")
	@RequestMapping("/admin/userloginlog/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, ModelMap model) {
			 
	  try{
			manager.deleteByIds(ids);
		} catch (DataIntegrityViolationException e) {
			log.error("批量删除失败",e);
			model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return list(pageable,new UserLoginLogSo(),  model);
	}

}