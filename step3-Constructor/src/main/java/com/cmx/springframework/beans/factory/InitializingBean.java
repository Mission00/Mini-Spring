package com.cmx.springframework.beans.factory;

public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
