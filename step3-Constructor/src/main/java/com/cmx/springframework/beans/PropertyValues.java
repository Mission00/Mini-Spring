package com.cmx.springframework.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }
    public PropertyValue getPropertyValue(String name){
        for (PropertyValue propertyValue : this.propertyValueList) {
            if(propertyValue.getName().equals(name)){
                return propertyValue;
            }
        }
        return null;
    }
}
