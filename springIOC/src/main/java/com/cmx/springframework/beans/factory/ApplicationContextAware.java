package com.cmx.springframework.beans.factory;

import com.cmx.springframework.beans.BeansException;
import com.cmx.springframework.context.ApplicationContext;

/**
 * Interface to be implemented by any object that wishes to be notifiedof the {@link ApplicationContext} that it runs in.
 * 实现此接口，既能感知到所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware{
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
