package com.cmx.springframework.bean;

public class UserService {

    private String name;
    private String uId;

    private UserDao userDao;

    public UserService() {

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
    public void queryUserInfo(String uId) {
        System.out.println(userDao.queryUserName(uId));
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", uId='" + uId + '\'' +
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
