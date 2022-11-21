package com.cmx.springframework.beans.factory.support;

import com.cmx.springframework.beans.BeansException;
import com.cmx.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        //通过beanDefinition获取class
        Class beanClass = beanDefinition.getBeanClass();
        try{
            if(null!=ctor){
                //核心为getDeclaredConstructor，该方法会根据传入的ctor.getParameterTypes返回对应的构造函数。
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else{
                return beanClass.getDeclaredConstructor().newInstance();
            }
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
