package org.example.proxy;

import javafx.beans.binding.ObjectExpression;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置增强");
        method.invoke(object,args);
        System.out.println("后置增强");
        return null;
    }
}
