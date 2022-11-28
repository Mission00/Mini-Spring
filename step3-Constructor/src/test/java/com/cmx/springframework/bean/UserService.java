package com.cmx.springframework.bean;

public class UserService {

    private String name;
    private String uId;
    private String company;
    private String location;

    private UserDao userDao;

    public UserService() {

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
