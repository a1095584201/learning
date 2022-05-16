package org.example.proxy;

import org.example.service.UserService;

public class StaticProxy implements UserService {

    private UserService user;

    public StaticProxy(UserService user) {
        this.user = user;
    }


    @Override
    public void save() {
        System.out.println("增强前置");
        user.save();
        System.out.println("增强后置");
    }
}
