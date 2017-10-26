package com.ada.quartz.task;

import com.ada.data.enums.State;
import com.ada.quartz.data.entity.CronTask;
import com.ada.quartz.data.entity.CronTaskRecord;
import com.ada.quartz.data.factory.ObjectFactory;
import com.ada.quartz.data.service.CronTaskRecordService;
import com.ada.quartz.data.service.CronTaskService;
import com.ada.utils.http.HttpConnection;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

public class HttpJob implements Job {

    private Logger logger = LoggerFactory.getLogger("ada");

    public void execute(JobExecutionContext context) throws JobExecutionException {
        Long time = System.currentTimeMillis();
        JobDataMap map = context.getJobDetail().getJobDataMap();
        String url = map.getString("url");
        logger.info("url:" + url);
        logger.info("time:" + new Date().toLocaleString());
        if (url != null) {
            try {
                HttpConnection.connect(url).timeout(20000).execute().body();
                logger.info("执行完成");
            } catch (IOException e) {
                // e.printStackTrace();
                logger.info("执行失败");
            }
        } else {
            logger.info("url为空");
        }
        time = System.currentTimeMillis() - time;
        Long id = map.getLong("id");
        if (id == null) {
            return;
        }

        CronTaskService service = ObjectFactory.get().getBean(CronTaskService.class);
        CronTask task = service.findById(id);
        if (task == null) {
            return;
        }


        task.setLastDate(new Date());
        task.setState(1);
        Long num = task.getNums();
        if (num == null) {
            num = 0l;
        }
        num = num + 1;
        task.setNums(num);
        service.update(task);


        if (task.getRecordState().equals(State.ON)) {
            CronTaskRecord record = new CronTaskRecord();
            record.setTask(task);
            record.setExpensesTime(time);
            record.setNote("");
            CronTaskRecordService recordService = ObjectFactory.get().getBean(CronTaskRecordService.class);
            recordService.save(record);
        }
    }

}
