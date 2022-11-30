package com.cmx.springframework.bean;


import com.cmx.springframework.beans.factory.DisposableBean;
import com.cmx.springframework.beans.factory.InitializingBean;

public class UserService implements InitializingBean, DisposableBean {

    private String name;
    private String uId;
    private String company;
    private String location;

    private UserDao userDao;

    public UserService() {

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

    public void queryUserInfo() {
        System.out.println(this.toString());
    }
    public String queryUserInfo(String uId) {
        System.out.println(this.toString());
        return userDao.queryUserName(uId);
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
