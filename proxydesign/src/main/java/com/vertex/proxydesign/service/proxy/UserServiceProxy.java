package com.vertex.proxydesign.service.proxy;

import com.vertex.proxydesign.service.UserService;
import com.vertex.proxydesign.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UserServiceProxy implements UserService {
    private final UserServiceImpl userService;

    public UserServiceProxy(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String getUser(String name) {
        System.out.println("Before executing real service");
        String result = userService.getUser(name);
        System.out.println("After executing real service");
        return result;
    }
}
