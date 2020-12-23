package com.wawahei.quartzdemo.springbootquartz.config;

import com.wawahei.quartzdemo.springbootquartz.job.AJob;
import com.wawahei.quartzdemo.springbootquartz.job.CJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: yanghailang
 * @create: 2020-12-21 14:57
 **/
@Configuration
public class QuartzConfiguration {

    @Autowired
    private ProjectConfig projectConfig;

    @Bean
    public JobDetail myCronJobDetail(){
        return JobBuilder.newJob(CJob.class)
                        .withIdentity(CJob.class.getName())
                        .storeDurably()
                        .build();
    }

    @Bean
    public Trigger cronJobTrigger(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(projectConfig.getCjobCron());
        return TriggerBuilder.newTrigger()
                        .forJob(myCronJobDetail())
                        .withIdentity(CJob.class.getName()+"_trigger")
                        .withSchedule(cronScheduleBuilder)
                        .build();
    }
}