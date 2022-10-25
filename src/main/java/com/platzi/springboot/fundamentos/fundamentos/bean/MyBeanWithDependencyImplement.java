package com.platzi.springboot.fundamentos.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 1;
        System.out.println("Hola desde la implementacion de un bean con dependencia");
        System.out.println("Operacion: " + myOperation.sum(numero));
    }
}
