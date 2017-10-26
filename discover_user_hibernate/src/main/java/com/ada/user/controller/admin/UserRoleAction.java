package com.ada.user.controller.admin;

import com.ada.data.page.Filter;
import com.ada.data.utils.FilterUtils;
import com.ada.user.data.service.MenuService;
import com.ada.user.data.service.UserRoleCatalogService;
import com.ada.user.data.so.UserRoleSo;
import com.ada.user.utils.ListUtils;
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
import com.ada.user.data.entity.UserRole;
import com.ada.user.data.service.UserRoleService;

/**
 * Created by imake on 2017年07月20日17:47:47.
 */
@Controller
public class UserRoleAction {

    public static final String MODEL = "model";

    private static final Logger log = LoggerFactory.getLogger(UserRoleAction.class);

    @Autowired
    private UserRoleService manager;


    @Autowired
    private UserRoleCatalogService catalogService;

    @Autowired
    MenuService menuService;

    @RequiresPermissions("userrole")
    @RequestMapping("/admin/userrole/view_list")
    public String list(Pageable pageable, UserRoleSo so, ModelMap model) {

        if (pageable != null) {
            if (pageable.getOrders() == null || pageable.getOrders().isEmpty()) {
                pageable.getOrders().add(Order.desc("id"));
            }
        }
        pageable.getFilters().addAll(FilterUtils.getFilters(so));
        Page<UserRole> pagination = manager.page(pageable);
        model.addAttribute("list", pagination.getContent());
        model.addAttribute("page", pagination);
        model.addAttribute("so", so);
        return "/admin/userrole/list";
    }

    @RequiresPermissions("userrole")
    @RequestMapping("/admin/userrole/view_add")
    public String add(ModelMap model) {
        initModel(model);

        return "/admin/userrole/add";
    }

    @RequiresPermissions("userrole")
    @RequestMapping("/admin/userrole/view_edit")
    public String edit(Pageable pageable, Long id, ModelMap model) {
        model.addAttribute(MODEL, manager.findById(id));
        model.addAttribute("page", pageable);

        initModel(model);

        return "/admin/userrole/edit";
    }

    public void initModel(ModelMap model) {
        model.addAttribute("menus", menuService.findChild(1));
        model.addAttribute("catalogs", catalogService.list(0, 100, ListUtils.list(Filter.eq("parent.id", 1)), ListUtils.list(Order.asc("sortNum"))));
    }

    @RequiresPermissions("userrole")
    @RequestMapping("/admin/userrole/view_view")
    public String view(Long id, ModelMap model) {
        model.addAttribute(MODEL, manager.findById(id));
        return "/admin/userrole/view";
    }

    @RequiresPermissions("userrole")
    @RequestMapping("/admin/userrole/model_save")
    public String save(UserRole bean, ModelMap model) {

        String view = "redirect:view_list.htm";
        try {
            manager.save(bean);
            log.info("save object id={}", bean.getId());
        } catch (Exception e) {
            log.error("保存失败", e);
            model.addAttribute("erro", e.getMessage());
            view = "/admin/userrole/add";
        }
        return view;
    }

    @RequiresPermissions("userrole")
    @RequestMapping("/admin/userrole/model_update")
    public String update(Pageable pageable, UserRole bean, ModelMap model) {

        String view = "redirect:/admin/userrole/view_list.htm?pageNumber=" + pageable.getPageNumber();
        try {
            manager.update(bean);
        } catch (Exception e) {
            log.error("更新失败", e);
            model.addAttribute("erro", e.getMessage());
            model.addAttribute(MODEL, bean);
            model.addAttribute("page", pageable);
            initModel(model);
            view = "/admin/userrole/edit";
        }
        return view;
    }

    @RequiresPermissions("userrole")
    @RequestMapping("/admin/userrole/model_delete")
    public String delete(Pageable pageable, Long id, ModelMap model) {

        try {
            manager.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            log.error("删除失败", e);
            model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
        }

        return list(pageable, new UserRoleSo(), model);
    }

    @RequiresPermissions("userrole")
    @RequestMapping("/admin/userrole/model_deletes")
    public String deletes(Pageable pageable, Long[] ids, ModelMap model) {

        try {
            manager.deleteByIds(ids);
        } catch (DataIntegrityViolationException e) {
            log.error("批量删除失败", e);
            model.addAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
        }
        return list(pageable, new UserRoleSo(), model);
    }

}