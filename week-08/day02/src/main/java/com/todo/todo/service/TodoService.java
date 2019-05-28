package com.todo.todo.service;

import com.todo.todo.model.Todo;
import com.todo.todo.repository.ITodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
  private ITodoRepository iTodoRepository;
  private List<Todo> todos;

  public List<Todo> getTodos() {
    return todos;
  }

  public void setTodos(List<Todo> todos) {
    this.todos = todos;
  }

  public TodoService(ITodoRepository iTodoRepository) {
    this.iTodoRepository = iTodoRepository;
    this.todos = new ArrayList<>();
    this.todos.add(new Todo(1, "Kovászolni", false, false));
    this.todos.add(new Todo(1, "Kenyeret sütni", false, true));
    this.todos.add(new Todo(1, "Kolbászt tölteni", true, false));
  }
}
