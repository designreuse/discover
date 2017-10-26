package com.ada.album.controller.admin;

import com.ada.data.utils.FilterUtils;
import com.ada.album.data.so.AlbumSo;
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
import  com.ada.album.data.entity.Album;
import com.ada.album.data.service.AlbumService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;

/**
*
* Created by imake on 2017年08月15日10:04:54.
*/


@Scope("prototype")
@Controller
public class AlbumAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(AlbumAction.class);

	@Autowired
	private AlbumService manager;

	@RequiresPermissions("album")
	@RequestMapping("/admin/album/view_list")
	public String list(Pageable pageable,AlbumSo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<Album> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/album/list";
	}

	@RequiresPermissions("album")
	@RequestMapping("/admin/album/view_add")
	public String add(ModelMap model) {
		return "/admin/album/add";
	}

	@RequiresPermissions("album")
	@RequestMapping("/admin/album/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/album/edit";
	}

	@RequiresPermissions("album")
	@RequestMapping("/admin/album/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/album/view";
	}

	@RequiresPermissions("album")
	@RequestMapping("/admin/album/model_save")
	public String save(Album bean,ModelMap model) {
	
	    String view="redirect:view_list.htm";
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/album/add";
		}
		return view;
	}

	@RequiresPermissions("album")
	@RequestMapping("/admin/album/model_update")
	public String update(Pageable pageable, Album bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view="redirect:/admin/album/view_list.htm";
		try {
			manager.update(bean);
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
		    model.addAttribute("page", pageable);
			view="/admin/album/edit";
		}
		return view;
	}
	@RequiresPermissions("album")
	@RequestMapping("/admin/album/model_delete")
	public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/album/view_list.htm";

		try {
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}

		return view;
	}

	@RequiresPermissions("album")
	@RequestMapping("/admin/album/model_deletes")
	public String deletes(Pageable pageable, Long[] ids,RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/album/view_list.htm";

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