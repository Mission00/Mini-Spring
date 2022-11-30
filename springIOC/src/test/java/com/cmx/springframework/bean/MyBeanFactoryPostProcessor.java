package com.cmx.springframework.bean;

import com.cmx.springframework.beans.BeansException;
import com.cmx.springframework.beans.PropertyValue;
import com.cmx.springframework.beans.PropertyValues;
import com.cmx.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.cmx.springframework.beans.factory.config.BeanDefinition;
import com.cmx.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
