package com.example.userservice;

import com.example.userservice.domain.dao.Role;
import com.example.userservice.domain.dao.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));


			userService.saveUser(new User(null, "John Travolta", "john", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "will", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "jim", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "Fatih Hazel", "fatih", "123", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_ADMIN");
			userService.addRoleToUser("fatih", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("fatih", "ROLE_ADMIN");
			userService.addRoleToUser("fatih", "ROLE_USER");
		};
	}

}
