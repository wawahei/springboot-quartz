package com.wawahei.quartzdemo.springbootquartz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yanghailang
 * @create: 2020-12-21 17:31
 **/
@Data
@Component
@ConfigurationProperties(prefix = "custom")
@PropertySource(value = "config.properties")
public class ProjectConfig {
    public String name;
    public String ajobCron;
    public String cjobCron;
}