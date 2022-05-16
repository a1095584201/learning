package org.example.proxy.test;

import org.example.impl.UserServiceImpl;
import org.example.proxy.DynamicProxy;
import org.example.service.UserService;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        UserService user=new UserServiceImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(user);
        UserService u=  (UserService)Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(),dynamicProxy);
        u.save();
    }
}
