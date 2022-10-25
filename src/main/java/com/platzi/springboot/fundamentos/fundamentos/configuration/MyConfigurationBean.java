package com.platzi.springboot.fundamentos.fundamentos.configuration;

import com.platzi.springboot.fundamentos.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean bean() {
        return new MyBeanTwoImplement();
    }

    @Bean
    public MyOperation beanOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation) {
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
