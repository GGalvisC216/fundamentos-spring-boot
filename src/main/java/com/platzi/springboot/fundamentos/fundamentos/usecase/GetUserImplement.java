package com.platzi.springboot.fundamentos.fundamentos.usecase;

import com.platzi.springboot.fundamentos.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
