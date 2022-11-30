package com.cmx.springframework.bean;


import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();
    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("1", "张三");
        hashMap.put("2", "李四");
        hashMap.put("3", "小雄");
    }

    public UserDao() {
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }


    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}