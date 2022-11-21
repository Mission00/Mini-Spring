package com.cmx.springframework.beans.factory;

import com.cmx.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
