package com.platzi.springboot.fundamentos.fundamentos.usecase;

import com.platzi.springboot.fundamentos.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(Long id, User newUser) {
        userService.update(id, newUser);
    }
}
