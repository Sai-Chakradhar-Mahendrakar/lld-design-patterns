package com.vertex.builderdesign.service;

import com.vertex.builderdesign.model.User;
import com.vertex.builderdesign.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User createUser(UserRequest request) {
        return new User.Builder()
                .id(100L)
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .city(request.getCity())
                .build();
    }
}
