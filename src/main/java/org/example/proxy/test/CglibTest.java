package org.example.proxy.test;

import org.example.model.UserDao;
import org.example.proxy.CglibProxy;

public class CglibTest {
    public static void main(String[] args) {
        UserDao userDao=new UserDao();
        UserDao instance = (UserDao)new CglibProxy(userDao).getInstance();
        instance.save();

        instance.update();
    }
}
