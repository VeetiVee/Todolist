package com.example.Todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Todolist.domain.Category;
import com.example.Todolist.domain.CategoryRepository;
import com.example.Todolist.domain.Todo;
import com.example.Todolist.domain.TodoRepository;
import com.example.Todolist.domain.User;
import com.example.Todolist.domain.UserRepository;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TodoRepository todoRepository, CategoryRepository crepository, UserRepository urepository) {
	return (args) -> {
		
		crepository.save(new Category("Sports"));
		crepository.save(new Category("School"));
		crepository.save(new Category("Work"));
		crepository.save(new Category("Other"));
		
		todoRepository.save(new Todo("Kiipeily", "08.11.2021", crepository.findByName("Sports").get(0)));
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
	};
	
	}
}
