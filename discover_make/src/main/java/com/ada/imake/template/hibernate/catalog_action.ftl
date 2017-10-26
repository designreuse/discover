package ${action};


import com.ada.data.page.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

<#if versionentity>
import com.ada.data.page.Filter;
</#if>
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import  ${entity.name};
import ${manager_p}.${entity.simpleName}Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/**
* Created by imake on ${.now?string("yyyy年MM月dd日HH:mm:ss")}.
*/

@Scope("prototype")
@Controller
public class ${entity.simpleName}Action {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(${entity.simpleName}Action.class);

	@Autowired
	private ${entity.simpleName}Service manager;

	@RequiresPermissions("${config_entity}")
	@RequestMapping("/admin/${config_entity}/view_list")
	public String list(Pageable pageable, @RequestParam(value="pid",defaultValue = "1") Integer pid,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
				pageable.getOrders().add(Order.asc("code"));
			}
			pageable.getFilters().add(Filter.eq("parent.id", pid));
			<#if versionentity>
			pageable.getFilters().add(Filter.ne("state", 3));
			</#if>
		}
		Page<${entity.simpleName}> pagination = manager.page(pageable);
		List<${entity.simpleName}> tops = manager.findByTops(pid);
		if (tops.size()==0&&pid==1){
			${entity.simpleName} root=new ${entity.simpleName}();
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
		return "/admin/${config_entity}/list";
	}

	@RequiresPermissions("${config_entity}")
	@RequestMapping("/admin/${config_entity}/view_add")
	public String add(ModelMap model) {
		return "/admin/${config_entity}/add";
	}

	@RequiresPermissions("${config_entity}")
	@RequestMapping("/admin/${config_entity}/view_edit")
	public String edit(Pageable pageable,${id.simpleName} id,  ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/${config_entity}/edit";
	}

	@RequiresPermissions("${config_entity}")
	@RequestMapping("/admin/${config_entity}/view_view")
	public String view(${id.simpleName} id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/${config_entity}/view";
	}

	@RequiresPermissions("${config_entity}")
	@RequestMapping("/admin/${config_entity}/model_save")
	public String save(Pageable pageable,${entity.simpleName} bean,ModelMap model) {
	
	    String view="redirect:/admin/${config_entity}/view_list.htm?pid=" + bean.getParentId() + "&pageNumber=" + pageable.getPageNumber();
		try {
			manager.save(bean);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			log.error("保存失败",e);
			model.addAttribute("erro", e.getMessage());
			view="/admin/${config_entity}/add";
		}
		return view;
	}

	@RequiresPermissions("${config_entity}")
	@RequestMapping("/admin/${config_entity}/model_update")
	public String update(Pageable pageable, ${entity.simpleName} bean,  RedirectAttributes redirectAttributes, ModelMap model) {

		String view="redirect:/admin/${config_entity}/view_list.htm";
		try {
			manager.update(bean);
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
		} catch (Exception e) {
			log.error("更新失败",e);
			model.addAttribute("erro", e.getMessage());
			model.addAttribute(MODEL,bean);
			model.addAttribute("page", pageable);
			view="/admin/${config_entity}/edit";
		}
		return view;
	}
	@RequiresPermissions("${config_entity}")
	@RequestMapping("/admin/${config_entity}/model_delete")
	public String delete(Pageable pageable, ${id.simpleName} id, RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/${config_entity}/view_list.htm";
		try {
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		}
		return view;
	}

	@RequiresPermissions("${config_entity}")
	@RequestMapping("/admin/${config_entity}/model_deletes")
	public String deletes(Pageable pageable, ${id.simpleName}[] ids,RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/${config_entity}/view_list.htm";

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