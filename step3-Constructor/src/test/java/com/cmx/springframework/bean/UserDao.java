package com.cmx.springframework.bean;

import com.cmx.springframework.beans.factory.config.BeanReference;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1", "张三");
        hashMap.put("2", "李四");
        hashMap.put("3", "小雄");
    }

    public UserDao() {
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}