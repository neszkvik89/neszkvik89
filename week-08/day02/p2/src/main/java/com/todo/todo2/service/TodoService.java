package com.todo.todo2.service;

import com.todo.todo2.model.Todo;
import com.todo.todo2.repository.ITodoRepository;
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
    iTodoRepository.save(new Todo(1, "Kovászolni", false, false));
    iTodoRepository.save(new Todo(2, "Kolbászt tölteni", false, true));
    iTodoRepository.save(new Todo(3, "Tehenet fejni", false, false));
    iTodoRepository.save(new Todo(4, "Krumplit szedni", true, false));
    iTodoRepository.save(new Todo(4, "Pénzt számolni", true, true));
    iTodoRepository.save(new Todo(4, "Adót fizetni",true, false));

  }
}
