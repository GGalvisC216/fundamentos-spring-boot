package com.platzi.springboot.fundamentos.fundamentos.configuration;

import com.platzi.springboot.fundamentos.fundamentos.service.UserService;
import com.platzi.springboot.fundamentos.fundamentos.usecase.GetUser;
import com.platzi.springboot.fundamentos.fundamentos.usecase.GetUserImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImplement(userService);
    }
}
