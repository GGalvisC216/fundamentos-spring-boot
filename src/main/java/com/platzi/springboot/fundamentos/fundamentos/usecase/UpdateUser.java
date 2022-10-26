package com.platzi.springboot.fundamentos.fundamentos.usecase;

import com.platzi.springboot.fundamentos.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public Optional<User> update(Long id, User newUser) {
        return userService.update(id, newUser);
    }
}
