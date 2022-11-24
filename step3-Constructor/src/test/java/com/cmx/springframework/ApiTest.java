package com.cmx.springframework;

import com.cmx.springframework.bean.UserDao;
import com.cmx.springframework.bean.UserService;
import com.cmx.springframework.beans.PropertyValue;
import com.cmx.springframework.beans.PropertyValues;
import com.cmx.springframework.beans.factory.config.BeanDefinition;
import com.cmx.springframework.beans.factory.config.BeanReference;
import com.cmx.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;


public class ApiTest {
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册一个Dao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "1"));
        propertyValues.addPropertyValue(new PropertyValue("name", "小雄"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        //4、UserService 注入带属性值的Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo("3");
    }

}
