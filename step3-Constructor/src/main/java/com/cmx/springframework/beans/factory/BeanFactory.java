package com.cmx.springframework.beans.factory;

import com.cmx.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name,Object... args) throws BeansException;
    /**
     * 根据名称和类型查找bean
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;


    boolean containsBean(String name);
}
