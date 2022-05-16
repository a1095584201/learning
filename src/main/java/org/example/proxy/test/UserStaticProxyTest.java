package org.example.proxy.test;

import org.example.impl.UserServiceImpl;
import org.example.proxy.StaticProxy;
import org.example.service.UserService;

public class UserStaticProxyTest {
    public static void main(String[] args) {
        UserService user =new UserServiceImpl();
        StaticProxy staticProxy = new StaticProxy(user);
        staticProxy.save();
    }
}
