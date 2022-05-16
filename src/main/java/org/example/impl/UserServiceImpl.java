package org.example.impl;

import org.example.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("user save");
    }
}
