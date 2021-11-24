package com.example.Todolist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Todolist.domain.CategoryRepository;
import com.example.Todolist.domain.Todo;
import com.example.Todolist.domain.TodoRepository;


@Controller
public class TodoController {
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private CategoryRepository crepository; 
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

	@RequestMapping(value = {"/", "/todolist"})
	public String bookList(Model model) {
	model.addAttribute("todos", todoRepository.findAll());
	return "todolist";
	}
	
	@RequestMapping(value="/todos", method = RequestMethod.GET)
    public @ResponseBody List<Todo> bookListRest() {	
        return (List<Todo>) todoRepository.findAll();
    }    
	
	@RequestMapping(value = "/add")
    public String addTodo(Model model){
    	model.addAttribute("todo", new Todo());
    	model.addAttribute("categories", crepository.findAll());
        return "addtodo";
    }     
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Todo todo){
        todoRepository.save(todo);
        return "redirect:todolist";
    }    
	
	  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteTodo(@PathVariable("id") Long TodoId, Model model) {
	    	todoRepository.deleteById(TodoId);
	        return "redirect:../todolist";
	    }     
	    
	  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String editBook(@PathVariable("id") Long TodoId, Model model) {
	    	Optional<Todo> todo = todoRepository.findById(TodoId);
	    	model.addAttribute("todo", todo);
	    	model.addAttribute("categories", crepository.findAll());
	    	return "edittodo";
	    }
	     
}
