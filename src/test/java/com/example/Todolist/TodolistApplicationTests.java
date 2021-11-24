package com.example.Todolist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Todolist.web.TodoController;



@ExtendWith(SpringExtension.class)
@SpringBootTest
class TodolistApplicationTests {

	@Autowired
	private TodoController controller;
	 @Test
	 public void contextLoads() throws Exception {
	 assertThat(controller).isNotNull();
	}

}