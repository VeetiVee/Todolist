package com.example.Todolist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String task, date;
	
	@ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
	
	public Todo() {}
	
	public Todo(String task, String date, Category category) {
		super();
		this.task = task;
		this.date = date;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Todo [id=" + id + ", task=" + task + ", date=" + date + " category =" + this.getCategory() + "]";
		else
			return "Book [id=" + id + ", task=" + task + ", date=" + date + "]";
	
	}
	
}
