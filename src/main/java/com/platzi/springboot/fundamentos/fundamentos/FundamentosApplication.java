package com.platzi.springboot.fundamentos.fundamentos;

import com.platzi.springboot.fundamentos.fundamentos.bean.MyBean;
import com.platzi.springboot.fundamentos.fundamentos.bean.MyBeanWithDependency;
import com.platzi.springboot.fundamentos.fundamentos.bean.MyBeanWithProperties;
import com.platzi.springboot.fundamentos.fundamentos.component.ComponentDependency;
import com.platzi.springboot.fundamentos.fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;


	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.toString());
		try {
			int value = 10/0;
			LOGGER.debug("Mi valor: " + value);
		} catch (Exception e) {
			LOGGER.error("Esto es un error por dividir entre cero", e);
		}

	}
}
