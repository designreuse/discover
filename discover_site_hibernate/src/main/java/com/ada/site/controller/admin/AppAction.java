package com.ada.site.controller.admin;


import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.site.data.entity.App;
import com.ada.site.data.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "admin")
public class AppAction {
	private static final Logger log = LoggerFactory.getLogger(AppAction.class);

	@RequestMapping("/app/view_list")
	public String list(Pageable pageable, HttpServletRequest request, ModelMap model) {
	
		if (pageable==null) {
			pageable=new Pageable();
		}
		if (pageable.getOrders()==null||pageable.getOrders().size()==0) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Page<App> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return "/admin/app/list";
	}

	@RequestMapping("/app/view_add")
	public String add(ModelMap model) {

		model.addAttribute("appKey",manager.key());
		model.addAttribute("appSecret",manager.secret());

		return "/admin/app/add";
	}

	@RequestMapping("/app/view_edit")
	public String edit(Pageable pageable, Long id, Integer pageNo, HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("page", pageable);
		return "/admin/app/edit";
	}

	@RequestMapping("/app/model_save")
	public String save(App bean, HttpServletRequest request, ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			bean = manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			view="/admin/app/add";
		}
		return view;
	}

	@RequestMapping("/app/model_update")
	public String update(Pageable pageable, App bean, HttpServletRequest request, ModelMap model) {
		
		String view="redirect:/admin/app/view_list.htm?pageNumber="+pageable.getPageNumber();
		try {
		bean = manager.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			model.addAttribute("model",bean);
		    model.addAttribute("page", pageable);
			view="/admin/app/edit";
		}
		return view;
	}

	@RequestMapping("/app/model_delete")
	public String delete(Pageable pageable, Long id, HttpServletRequest request, ModelMap model) {
			 
				manager.deleteById(id);
			 
		return "redirect:/admin/app/view_list.htm?pageNumber="+pageable.getPageNumber();
	}
	@RequestMapping("/app/model_deletes")
	public String deletes(Pageable pageable, Long[] ids, HttpServletRequest request, ModelMap model) {
			 
				manager.deleteByIds(ids);
			 
		return "redirect:/admin/app/view_list.htm?pageNumber="+pageable.getPageNumber();
	}
	@Autowired
	private AppService manager;
}