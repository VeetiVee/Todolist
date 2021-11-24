package com.example.Todolist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Todolist.domain.Category;
import com.example.Todolist.domain.Todo;
import com.example.Todolist.domain.TodoRepository;




@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TodoRepositoryTest {
	
	@Autowired
	private TodoRepository repository;
	
	@Test
    public void findByTaskShouldReturnTodo() {
        List<Todo> todos = repository.findByTask("Kiipeily");
        
        assertThat(todos).hasSize(1);
        assertThat(todos.get(0).getDate()).isEqualTo("08.11.2021");
    }
	
	 @Test
	    public void createNewBook() {
	    	Todo todo = new Todo("Synttärit", "27.11.2021", new Category("Friends"));
	    	repository.save(todo);
	    	assertThat(todo.getId()).isNotNull();
	    }    
}


