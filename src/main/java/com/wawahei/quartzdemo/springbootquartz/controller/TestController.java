package com.wawahei.quartzdemo.springbootquartz.controller;

import com.wawahei.quartzdemo.springbootquartz.config.ProjectConfig;
import com.wawahei.quartzdemo.springbootquartz.job.AJob;
import com.wawahei.quartzdemo.springbootquartz.job.BJob;
import com.wawahei.quartzdemo.springbootquartz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @description:
 * @author: yanghailang
 * @create: 2020-12-22 16:49
 **/
@RestController
@Slf4j
public class TestController {

    @Autowired
    private ProjectConfig projectConfig;

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(){
        startAJob();
        startBJob();
        return "a";
    }

    private void startAJob() {
        try {
            String name = UUID.randomUUID().toString();
            String group = AJob.class.getName();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(projectConfig.getAjobCron());
            JobDetail jobDetail = JobBuilder.newJob(AJob.class).withIdentity(name,group).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).withSchedule(cronScheduleBuilder).build();
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            log.error("TestController.startAJob",e);
        }
    }

    private void startBJob() {
        try {
            String name = UUID.randomUUID().toString();
            String group = BJob.class.getName();
            long startTime = System.currentTimeMillis() + 1000 * 2 * 60;
            JobDetail jobDetail = JobBuilder.newJob(BJob.class).withIdentity(name,group).build();
            jobDetail.getJobDataMap().put("name","kk");
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).startAt(new Date(startTime)).build();
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            log.error("TestController.startBJob",e);
        }
    }
}