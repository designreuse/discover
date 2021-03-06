package com.ada.article.controller.admin;


import com.ada.data.page.Filter;
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
import  com.ada.article.data.entity.ArticleCatalog;
import com.ada.article.data.service.ArticleCatalogService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/**
* Created by imake on 2017年08月15日09:52:13.
*/

@Scope("prototype")
@Controller
public class ArticleCatalogAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(ArticleCatalogAction.class);

	@Autowired
	private ArticleCatalogService manager;

	@RequiresPermissions("articlecatalog")
	@RequestMapping("/admin/articlecatalog/view_list")
	public String list(Pageable pageable, @RequestParam(value="pid",defaultValue = "1") Integer pid,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
				pageable.getOrders().add(Order.asc("code"));
			}
			pageable.getFilters().add(Filter.eq("parent.id", pid));
		}
		Page<ArticleCatalog> pagination = manager.page(pageable);
		List<ArticleCatalog> tops = manager.findByTops(pid);
		if (tops.size()==0&&pid==1){
			ArticleCatalog root=new ArticleCatalog();
			root.setName("根节点");
			root.setLevelInfo(1);
			root.setCode("");
			root.setSortNum(0);
			manager.save(root);
		}
		model.addAttribute("tops",tops);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("pid", pid);
		return "/admin/articlecatalog/list";
	}

	@RequiresPermissions("articlecatalog")
	@RequestMapping("/admin/articlecatalog/view_add")
	public String add(ModelMap model) {
		return "/admin/articlecatalog/add";
	}

	@RequiresPermissions("articlecatalog")
	@RequestMapping("/admin/articlecatalog/view_edit")
	public String edit(Pageable pageable,Integer id,  ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/articlecatalog/edit";
	}

	@RequiresPermissions("articlecatalog")
	@RequestMapping("/admin/articlecatalog/view_view")
	public String view(Integer id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/articlecatalog/view";
	}

	@RequiresPermissions("articlecatalog")
	@RequestMapping("/admin/articlecatalog/model_save")
	public String save(Pageable pageable,ArticleCatalog bean,ModelMap model) {
	
	    String view="redirect:/admin/articlecatalog/view_list.htm?pid=" + bean.getParentId() + "&pageNumber=" + pageable.getPageNumber();
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/articlecatalog/add";
		}
		return view;
	}

	@RequiresPermissions("articlecatalog")
	@RequestMapping("/admin/articlecatalog/model_update")
	public String update(Pageable pageable, ArticleCatalog bean,  RedirectAttributes redirectAttributes, ModelMap model) {

		String view="redirect:/admin/articlecatalog/view_list.htm";
		try {
			manager.update(bean);
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
			model.addAttribute("page", pageable);
			view="/admin/articlecatalog/edit";
		}
		return view;
	}
	@RequiresPermissions("articlecatalog")
	@RequestMapping("/admin/articlecatalog/model_delete")
	public String delete(Pageable pageable, Integer id, RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/articlecatalog/view_list.htm";
		try {
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return view;
	}

	@RequiresPermissions("articlecatalog")
	@RequestMapping("/admin/articlecatalog/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids,RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/articlecatalog/view_list.htm";

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