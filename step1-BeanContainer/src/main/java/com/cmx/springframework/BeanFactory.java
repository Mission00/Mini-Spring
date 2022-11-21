package com.cmx.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * auth :小雄不是大雄
 * date: 2022/11/20
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
