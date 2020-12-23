package com.wawahei.quartzdemo.springbootquartz.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yanghailang
 * @create: 2020-12-21 17:43
 **/
@Component
public class SpringUtils implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtils.applicationContext == null){
            SpringUtils.applicationContext = applicationContext;
        }
    }

    public static synchronized ApplicationContext getApplicationContext() {
        return SpringUtils.applicationContext;
    }
    //根据name
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }
    //根据类型
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

}