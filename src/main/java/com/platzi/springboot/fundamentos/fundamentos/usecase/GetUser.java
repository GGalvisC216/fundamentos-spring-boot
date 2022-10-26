package com.platzi.springboot.fundamentos.fundamentos.usecase;

import com.platzi.springboot.fundamentos.fundamentos.entity.User;

import java.util.List;

public interface GetUser {
    List<User> getAll();
}
