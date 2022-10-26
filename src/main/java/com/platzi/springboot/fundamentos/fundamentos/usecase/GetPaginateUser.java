package com.platzi.springboot.fundamentos.fundamentos.usecase;

import com.platzi.springboot.fundamentos.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.fundamentos.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPaginateUser {
    private UserService userService;

    public GetPaginateUser(UserService userService) {
        this.userService = userService;
    }

    public List<User> getPaginateUser(Pageable pageable) {
        return userService.getPaginateUser(pageable);
    }
}
