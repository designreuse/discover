package com.ada.ad.controller.admin;

import com.ada.ad.data.entity.AdPosition;
import com.ada.ad.data.service.AdPositionService;
import com.ada.data.utils.FilterUtils;
import com.ada.ad.data.so.AdSo;
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
import  com.ada.ad.data.entity.Ad;
import com.ada.ad.data.service.AdService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;

/**
*
* Created by imake on 2017年10月10日12:04:43.
*/


@Scope("prototype")
@Controller
public class AdAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(AdAction.class);

	@Autowired
	private AdService manager;

	@Autowired
	private AdPositionService positionService;

	@RequiresPermissions("ad")
	@RequestMapping("/admin/ad/view_list")
	public String list(Pageable pageable,AdSo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<Ad> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/ad/list";
	}

	@RequiresPermissions("ad")
	@RequestMapping("/admin/ad/view_add")
	public String add(ModelMap model) {
		initModel(model);
		return "/admin/ad/add";
	}

	@RequiresPermissions("ad")
	@RequestMapping("/admin/ad/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		initModel(model);
		return "/admin/ad/edit";
	}

	public void initModel(ModelMap model) {
		model.addAttribute("catalogs",positionService.child(1,100));
	}

	@RequiresPermissions("ad")
	@RequestMapping("/admin/ad/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/ad/view";
	}

	@RequiresPermissions("ad")
	@RequestMapping("/admin/ad/model_save")
	public String save(Ad bean,ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/ad/add";
		}
		return view;
	}

	@RequiresPermissions("ad")
	@RequestMapping("/admin/ad/model_update")
	public String update(Pageable pageable, Ad bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view="redirect:/admin/ad/view_list.htm";
		try {
			manager.update(bean);
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/ad/edit";
		}
		return view;
	}
	@RequiresPermissions("ad")
	@RequestMapping("/admin/ad/model_delete")
	public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/ad/view_list.htm";

		try {
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}

		return view;
	}

	@RequiresPermissions("ad")
	@RequestMapping("/admin/ad/model_deletes")
	public String deletes(Pageable pageable, Long[] ids,RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/ad/view_list.htm";

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