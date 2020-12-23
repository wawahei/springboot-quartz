package com.wawahei.quartzdemo.springbootquartz.job;

import com.wawahei.quartzdemo.springbootquartz.config.ProjectConfig;
import com.wawahei.quartzdemo.springbootquartz.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @description:
 * @author: yanghailang
 * @create: 2020-12-22 17:05
 **/
@Slf4j
public class BJob extends QuartzJobBean{
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ProjectConfig projectConfig = SpringUtils.getBean(ProjectConfig.class);
        log.info(projectConfig.getName());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String name = jobDataMap.getString("name");
        log.info(BJob.class.getName()+"执行了，name:{}",name);
    }
}