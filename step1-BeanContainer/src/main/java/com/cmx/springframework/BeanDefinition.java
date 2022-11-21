package com.cmx.springframework;

/**
 * auth :小雄不是大雄
 * date: 2022/11/20
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
