package com.vertex.proxydesign.service.impl;

import com.vertex.proxydesign.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(String name) {
        System.out.println("Executing real service");
        return "User: " + name;
    }
}
