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
 * @create: 2020-12-23 08:56
 **/
@Slf4j
public class CJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ProjectConfig projectConfig = SpringUtils.getBean(ProjectConfig.class);
        log.info(projectConfig.getName());
        log.info(CJob.class.getName()+"执行了.");
    }
}