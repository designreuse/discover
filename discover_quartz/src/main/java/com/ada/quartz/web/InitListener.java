package com.ada.quartz.web;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener implements ServletContextListener {

    private Logger logger= LoggerFactory.getLogger("ada");

    private Scheduler getScheduler() {
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return scheduler;
    }


    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Scheduler scheduler = getScheduler();
        if (scheduler == null) {
            return;
        }
        try {
            if (!scheduler.isStarted()) {
                scheduler.start();
                logger.info("初始化定时器成功");
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Scheduler scheduler = getScheduler();
        if (scheduler == null) {
            return;
        }
        try {
            if (scheduler.isStarted()) {
                scheduler.shutdown();
                logger.info("关闭定时器");
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
