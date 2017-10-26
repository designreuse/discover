package com.ada.quartz.controller.admin;

import com.ada.data.utils.FilterUtils;
import com.ada.quartz.data.so.CronTaskSo;
import com.ada.quartz.task.HttpJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import  com.ada.quartz.data.entity.CronTask;
import com.ada.quartz.data.service.CronTaskService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.context.annotation.Scope;

/**
*
* Created by imake on 2017年08月24日14:31:27.
*/


@Scope("prototype")
@Controller
public class CronTaskAction {

	public static final String MODEL = "model";

	private static final Logger log = LoggerFactory.getLogger(CronTaskAction.class);

	private Scheduler getScheduler() {
		Scheduler scheduler = null;
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scheduler;
	}

	@Autowired
	private CronTaskService manager;

	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/view_list")
	public String list(Pageable pageable,CronTaskSo so,ModelMap model) {
	
		if (pageable!=null) {
			if (pageable.getOrders()==null||pageable.getOrders().isEmpty()) {
			pageable.getOrders().add(Order.desc("id"));
			}
		}
		pageable.getFilters().addAll(FilterUtils.getFilters(so));
		Page<CronTask> pagination = manager.page(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("so", so);
		return "/admin/crontask/list";
	}

	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/view_add")
	public String add(ModelMap model) {
		return "/admin/crontask/add";
	}

	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/view_edit")
	public String edit(Pageable pageable,Long id, ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		model.addAttribute("page", pageable);
		return "/admin/crontask/edit";
	}

	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/view_view")
	public String view(Long id,ModelMap model) {
		model.addAttribute(MODEL, manager.findById(id));
		return "/admin/crontask/view";
	}

	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/model_save")
	public String save(CronTask bean,ModelMap model) {
	
	    String view="redirect:view_list.htm";
		if (bean.getCron() == null || !CronExpression.isValidExpression(bean.getCron())) {
			model.addAttribute("erro", "cron无效");
			return "/admin/crontask/add";
		}
		try {
			bean = manager.save(bean);

			Scheduler scheduler = getScheduler();
			Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(bean.getCron()))
					.withIdentity("trigger" + bean.getId(), "group" + bean.getId()).build();
			JobDetail jobDetail = JobBuilder.newJob(HttpJob.class)
					.withIdentity("job" + bean.getId(), "group" + bean.getId()).usingJobData("url", bean.getUrl())
					.usingJobData("id", bean.getId()).withDescription(bean.getNote()).build();

			scheduler.scheduleJob(jobDetail, trigger);
			log.info("save object id={}", bean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			view = "/admin/crontask/add";
		}
		return view;
	}

	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/model_update")
	public String update(Pageable pageable, CronTask bean, RedirectAttributes redirectAttributes, ModelMap model) {
		
		String view="redirect:/admin/crontask/view_list.htm";
		redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());

		if (bean.getCron() == null || !CronExpression.isValidExpression(bean.getCron())) {
			model.addAttribute("erro", "cron无效");
			model.addAttribute("model", bean);
			model.addAttribute("pageNo", pageable.getPageNumber());
			model.addAttribute("page", pageable);
			return "/admin/crontask/edit";
		}
		try {

			bean = manager.update(bean);
			Scheduler scheduler = getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey("trigger" + bean.getId(), "group" + bean.getId());
			scheduler.pauseTrigger(triggerKey);
			scheduler.unscheduleJob(triggerKey);


			Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(bean.getCron()))
					.withIdentity("trigger" + bean.getId(), "group" + bean.getId()).build();
			JobDetail jobDetail = JobBuilder.newJob(HttpJob.class)
					.withIdentity("job" + bean.getId(), "group" + bean.getId()).usingJobData("url", bean.getUrl())
					.usingJobData("id", bean.getId()).build();

			scheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erro", e.getMessage());
			model.addAttribute("model", bean);
			model.addAttribute("page", pageable);
			view = "/admin/crontask/edit";
		}
		return view;
	}
	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/model_delete")
	public String delete(Pageable pageable, Long id, RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/crontask/view_list.htm";

		try {
			redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());

			Scheduler scheduler = getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey("trigger" + id, "group" + id);
			scheduler.pauseTrigger(triggerKey);
			scheduler.unscheduleJob(triggerKey);

			manager.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			log.error("删除失败",e);
			redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

		return view;
	}

	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/model_deletes")
	public String deletes(Pageable pageable, Long[] ids,RedirectAttributes redirectAttributes) {

		String view="redirect:/admin/crontask/view_list.htm";

		try{
				redirectAttributes.addAttribute("pageNumber",pageable.getPageNumber());
				manager.deleteByIds(ids);
			} catch (DataIntegrityViolationException e) {
				log.error("批量删除失败",e);
				redirectAttributes.addFlashAttribute("erro", "该条数据不能删除，请先删除和他相关的类容!");
			}
		return view;
	}

	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/pause")
	public String pause(Pageable pageable, Long id,  ModelMap model) {

		String view = "redirect:/admin/crontask/view_list.htm?pageNumber=" + pageable.getPageNumber();
		try {
			Scheduler scheduler = getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey("trigger" + id, "group" + id);
			scheduler.pauseTrigger(triggerKey);
			CronTask task = manager.findById(id);
			if (task != null) {
				task.setState(0);
				manager.update(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}

	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/resume")
	public String resume(Pageable pageable, Long id, ModelMap model) {

		String view = "redirect:/admin/crontask/view_list.htm?pageNumber=" + pageable.getPageNumber();
		try {
			Scheduler scheduler = getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey("trigger" + id, "group" + id);
			scheduler.resumeTrigger(triggerKey);
			CronTask task = manager.findById(id);
			if (task != null) {
				task.setState(1);
				manager.update(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}


	@RequiresPermissions("crontask")
	@RequestMapping("/admin/crontask/demo")
	public String demo(Pageable pageable, Long id,ModelMap model) {

		String view = "redirect:/admin/crontask/view_list.htm?pageNumber=" + pageable.getPageNumber();
		try {
			Scheduler scheduler = getScheduler();
			scheduler.triggerJob(JobKey.jobKey("job" + id, "group" + id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}




	/**
	 * @param model
	 */
	private void init(Model model) {
		Scheduler scheduler = getScheduler();
		if (scheduler != null) {
			try {
				model.addAttribute("schedulerName", scheduler.getSchedulerName());
				if (scheduler.isStarted()) {
					model.addAttribute("started", true);
				} else {
					model.addAttribute("started", false);
				}
				if (scheduler.isShutdown()) {
					model.addAttribute("shutdown", true);
				} else {
					model.addAttribute("shutdown", false);
				}
				model.addAttribute("instanceId", scheduler.getSchedulerInstanceId());
				model.addAttribute("nums", scheduler.getMetaData().getNumberOfJobsExecuted());
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
	}


	@RequiresPermissions("crontask")
	@RequestMapping(value = "/admin/crontask/index")
	public String home( Model model) {
		init(model);
		return "admin/crontask/index";
	}

	@RequestMapping(value = "/admin/crontask/run")
	public String run( Model model) {
		Scheduler scheduler = getScheduler();
		if (scheduler != null) {
			try {
				if (scheduler.isStarted()) {
				} else {
					scheduler.start();
				}
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		init(model);
		return "redirect:/admin/crontask/index.htm";
	}

	@RequestMapping(value = "/admin/crontask/stop")
	public String stop( Model model) {
		Scheduler scheduler = getScheduler();
		if (scheduler != null) {
			try {
				if (scheduler.isStarted()) {
					scheduler.shutdown();
				} else {

				}
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/admin/crontask/index.htm";
	}

	@RequestMapping(value = "/admin/crontask/resumeall")
	public String resumeAll(Model model) {
		Scheduler scheduler = getScheduler();
		if (scheduler != null) {
			try {
				scheduler.resumeAll();
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/admin/crontask/index.htm";
	}

	@RequestMapping(value = "/admin/crontask/pauseall")
	public String pauseAll( Model model) {
		Scheduler scheduler = getScheduler();
		if (scheduler != null) {
			try {
				scheduler.pauseAll();
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/admin/crontask/index.htm";
	}

}