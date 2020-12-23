package com.wawahei.quartzdemo.springbootquartz.job;

import com.wawahei.quartzdemo.springbootquartz.config.ProjectConfig;
import com.wawahei.quartzdemo.springbootquartz.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @description:
 * @author: yanghailang
 * @create: 2020-12-21 15:01
 **/
@Slf4j
public class AJob extends QuartzJobBean {
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ProjectConfig projectConfig = SpringUtils.getBean(ProjectConfig.class);
        log.info(projectConfig.getName());
        log.info(AJob.class.getName()+"执行了.");
    }
}