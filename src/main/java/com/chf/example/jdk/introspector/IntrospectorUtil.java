package com.chf.example.jdk.introspector;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import domain.A;

public class IntrospectorUtil {

    public static void setValue(Object bean, String fieldName, Object value) {
        PropertyDescriptor propDesc;
        try {
            propDesc = new PropertyDescriptor(fieldName, bean.getClass());
            Method method = propDesc.getWriteMethod();
            method.invoke(bean, value);
        } catch (IntrospectionException | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static Object getValue(Object bean, String fieldName) {
        PropertyDescriptor propDesc;
        try {
            propDesc = new PropertyDescriptor(fieldName, bean.getClass());
            Method method = propDesc.getReadMethod();
            return method.invoke(bean);
            // return propDesc.getValue(fieldName);
        } catch (IntrospectionException | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        A a = new A();
        setValue(a, "num", 2);
        setValue(a, "str", "12");

        System.out.println(a);
        System.out.println(getValue(a, "num"));

    }
}
