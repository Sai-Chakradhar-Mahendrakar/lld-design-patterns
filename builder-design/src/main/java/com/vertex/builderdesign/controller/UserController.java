package com.vertex.builderdesign.controller;

import com.vertex.builderdesign.model.User;
import com.vertex.builderdesign.request.UserRequest;
import com.vertex.builderdesign.response.UserResponse;
import com.vertex.builderdesign.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest);

        return new UserResponse.Builder()
                .id(user.getId())
                .message("User created successfully")
                .build();
    }
}
