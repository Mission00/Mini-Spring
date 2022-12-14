package com.cmx.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.cmx.springframework.beans.BeansException;
import com.cmx.springframework.beans.PropertyValue;
import com.cmx.springframework.beans.core.io.Resource;
import com.cmx.springframework.beans.core.io.ResourceLoader;
import com.cmx.springframework.beans.factory.config.BeanDefinition;
import com.cmx.springframework.beans.factory.config.BeanReference;
import com.cmx.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.cmx.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public static final String BEAN_ELEMENT = "bean";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";
    public static final String INIT_METHOD_ATTRIBUTE = "init-method";
    public static final String DESTROY_METHOD_ATTRIBUTE = "destroy-method";
    public static final String SCOPE_ATTRIBUTE = "scope";
    public static final String BASE_PACKAGE_ATTRIBUTE = "base-package";
    public static final String COMPONENT_SCAN_ELEMENT = "component-scan";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }


    //    protected void doLoadBeanDefinitions(InputStream inputStream) throws DocumentException {
//        SAXReader reader = new SAXReader();
//        Document document = reader.read(inputStream);
//
//        Element root = document.getRootElement();
//
//        //??????context:component-scan???????????????????????????????????????????????????????????????BeanDefinition
//        Element componentScan = root.element(COMPONENT_SCAN_ELEMENT);
//        if (componentScan != null) {
//            String scanPath = componentScan.attributeValue(BASE_PACKAGE_ATTRIBUTE);
//            if (StrUtil.isEmpty(scanPath)) {
//                throw new BeansException("The value of base-package attribute can not be empty or null");
//            }
//            scanPackage(scanPath);
//        }
//
//        List<Element> beanList = root.elements(BEAN_ELEMENT);
//        for (Element bean : beanList) {
//            String beanId = bean.attributeValue(ID_ATTRIBUTE);
//            String beanName = bean.attributeValue(NAME_ATTRIBUTE);
//            String className = bean.attributeValue(CLASS_ATTRIBUTE);
//            String initMethodName = bean.attributeValue(INIT_METHOD_ATTRIBUTE);
//            String destroyMethodName = bean.attributeValue(DESTROY_METHOD_ATTRIBUTE);
//            String beanScope = bean.attributeValue(SCOPE_ATTRIBUTE);
//
//            Class<?> clazz;
//            try {
//                clazz = Class.forName(className);
//            } catch (ClassNotFoundException e) {
//                throw new BeansException("Cannot find class [" + className + "]");
//            }
//            //id?????????name
//            beanName = StrUtil.isNotEmpty(beanId) ? beanId : beanName;
//            if (StrUtil.isEmpty(beanName)) {
//                //??????id???name????????????????????????????????????????????????????????????bean?????????
//                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
//            }
//
//            BeanDefinition beanDefinition = new BeanDefinition(clazz);
//            beanDefinition.setInitMethodName(initMethodName);
//            beanDefinition.setDestroyMethodName(destroyMethodName);
//            if (StrUtil.isNotEmpty(beanScope)) {
//                beanDefinition.setScope(beanScope);
//            }
//
//            List<Element> propertyList = bean.elements(PROPERTY_ELEMENT);
//            for (Element property : propertyList) {
//                String propertyNameAttribute = property.attributeValue(NAME_ATTRIBUTE);
//                String propertyValueAttribute = property.attributeValue(VALUE_ATTRIBUTE);
//                String propertyRefAttribute = property.attributeValue(REF_ATTRIBUTE);
//
//                if (StrUtil.isEmpty(propertyNameAttribute)) {
//                    throw new BeansException("The name attribute cannot be null or empty");
//                }
//
//                Object value = propertyValueAttribute;
//                if (StrUtil.isNotEmpty(propertyRefAttribute)) {
//                    value = new BeanReference(propertyRefAttribute);
//                }
//                PropertyValue propertyValue = new PropertyValue(propertyNameAttribute, value);
//                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
//            }
//            if (getRegistry().containsBeanDefinition(beanName)) {
//                //beanName????????????
//                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
//            }
//            //??????BeanDefinition
//            getRegistry().registerBeanDefinition(beanName, beanDefinition);
//        }
//    }
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            // ????????????
            if (!(childNodes.item(i) instanceof Element)) continue;
            // ????????????
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            // ????????????
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            //?????????init-method???destroy-method?????????
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");
            // ?????? Class??????????????????????????????
            Class<?> clazz = Class.forName(className);
            // ????????? id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // ??????Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            //???????????????beanDefinition???
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            // ?????????????????????
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;
                // ???????????????property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // ??????????????????????????????????????????
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // ??????????????????
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // ?????? BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
