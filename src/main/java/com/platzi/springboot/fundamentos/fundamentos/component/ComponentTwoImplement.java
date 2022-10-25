package com.platzi.springboot.fundamentos.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola mundo dede el componente 2");
    }
}
