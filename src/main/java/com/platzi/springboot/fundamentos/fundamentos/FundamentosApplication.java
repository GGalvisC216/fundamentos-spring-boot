package com.platzi.springboot.fundamentos.fundamentos;

import com.platzi.springboot.fundamentos.fundamentos.bean.MyBean;
import com.platzi.springboot.fundamentos.fundamentos.bean.MyBeanWithDependency;
import com.platzi.springboot.fundamentos.fundamentos.bean.MyBeanWithProperties;
import com.platzi.springboot.fundamentos.fundamentos.component.ComponentDependency;
import com.platzi.springboot.fundamentos.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.fundamentos.pojo.UserPojo;
import com.platzi.springboot.fundamentos.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;


	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//previousClasses();
		saveUsersInDatabase();
		getUserInformationWithJpql();
	}

	private void getUserInformationWithJpql() {
		/*
		LOGGER.info("Usuario con el metodo findUserByEmail: " +
				userRepository.findUserByEmail("john@domain.com")
					.orElseThrow(()->new RuntimeException("No se encontro usuario")));

		userRepository.findAndSort("Fer", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con metodo sort " + user));
		userRepository.findByName("John")
				.stream()
				.forEach(user -> LOGGER.info("Usuario con query method " + user));
		LOGGER.info("Usuario con query method findByNameAndEmail " +
			userRepository.findByNameAndEmail("Andres", "andres@domain.com")
				.orElseThrow(()->new RuntimeException("Usuario no encontrado")));
		userRepository.findByNameLike("%ri%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameLike " + user));
		userRepository.findByNameLikeAndEmailLike("%ri%", "%ris%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameLikeAndEmailLike " + user));
		userRepository.findByNameOrEmail(null, "carlos@domain.com")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameOrEmail " + user));

		 */
		userRepository.findByBirthDateBetween(
					LocalDate.of(1991,1,1),
					LocalDate.of(1997,1,1)
				).stream()
				.forEach(user -> LOGGER.info("Usuario con intervalo de fechas " + user));
		userRepository.findByNameLikeOrderByIdDesc("%ri%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario encontrado con like y ordenado " + user));
		userRepository.findByNameContainingOrderByIdDesc("ri")
				.stream()
				.forEach(user -> LOGGER.info("Usuario encontrado con containing y ordenado " + user));
	}

	private void saveUsersInDatabase() {
		User user1 = new User("John", "john@domain.com", LocalDate.of(2000,3,20));
		User user2 = new User("Julie", "julie@domain.com", LocalDate.of(1999,4,11));
		User user3 = new User("Andres", "andres@domain.com", LocalDate.of(1996,5,12));
		User user4 = new User("Carlos", "carlos@domain.com", LocalDate.of(1990,6,13));
		User user5 = new User("Luisa", "luisa@domain.com", LocalDate.of(1991,7,14));
		User user6 = new User("Fernando", "fernando@domain.com", LocalDate.of(1992,8,15));
		User user7 = new User("Rodrigo", "rodrigo@domain.com", LocalDate.of(1993,9,16));
		User user8 = new User("Maria", "maria@domain.com", LocalDate.of(1994,10,17));
		User user9 = new User("Cristian", "cristian@domain.com", LocalDate.of(1995,11,18));
		User user10 = new User("Fernanda", "patricia@domain.com", LocalDate.of(1996,12,19));
		User user11 = new User("Gerardo", "gerardo@domain.com", LocalDate.of(1997,1,1));
		User user12 = new User("Katherine", "katherine@domain.com", LocalDate.of(1998,2,7));

		List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7,
				user8, user9, user10, user11, user12);
		users.stream().forEach(userRepository::save);
	}

	private void previousClasses() {
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
