package com.example.Todolist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

	List<Todo> findByTask(String task);
}
