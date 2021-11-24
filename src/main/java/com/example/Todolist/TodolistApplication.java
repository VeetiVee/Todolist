package com.example.Todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Todolist.domain.Category;
import com.example.Todolist.domain.CategoryRepository;
import com.example.Todolist.domain.Todo;
import com.example.Todolist.domain.TodoRepository;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TodoRepository todoRepository, CategoryRepository crepository) {
	return (args) -> {
		
		crepository.save(new Category("Sports"));
		crepository.save(new Category("School"));
		crepository.save(new Category("Work"));
		crepository.save(new Category("Other"));
		
		todoRepository.save(new Todo("Kiipeily", "08.11.2021", crepository.findByName("Sports").get(0)));
		
	};
	
	}
}
