package com.cmx.springframework.bean;


import com.cmx.springframework.beans.BeansException;
import com.cmx.springframework.beans.factory.*;
import com.cmx.springframework.context.ApplicationContext;

import java.util.Random;

public class UserService implements IUserService,BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware ,InitializingBean, DisposableBean {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;


    private String name;
    private String uId;
    private String company;
    private String location;

    private UserDao userDao;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小雄不是大雄，351100，pt";
    }


    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }


    public UserService() {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    public String getCompany() {
        return company;
    }

    public UserService setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public UserService setLocation(String location) {
        this.location = location;
        return this;
    }

    public UserService(String name) {
        this.name = name;
    }


    public UserService(String name, String uId, UserDao userDao) {
        this.name = name;
        this.uId = uId;
        this.userDao = userDao;
    }
    public String queryUserInfo(String uId) {
        System.out.println(this.toString());
        return userDao.queryUserName(uId);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", uId='" + uId + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", userDao=" + userDao +
                '}';
    }

    public String getName() {
        return name;
    }

    public UserService setName(String name) {
        this.name = name;
        return this;
    }

    public String getuId() {
        return uId;
    }

    public UserService setuId(String uId) {
        this.uId = uId;
        return this;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public UserService setUserDao(UserDao userDao) {
        this.userDao = userDao;
        return this;
    }


}
