package com.cmx.springframework.beans.factory.support;

import com.cmx.springframework.beans.BeansException;
import com.cmx.springframework.beans.factory.ApplicationContextAware;
import com.cmx.springframework.beans.factory.config.BeanPostProcessor;
import com.cmx.springframework.context.ApplicationContext;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
