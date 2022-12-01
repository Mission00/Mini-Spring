package com.cmx.springframework.beans.factory;

public interface DisposableBean {
    void destroy() throws Exception;

}
