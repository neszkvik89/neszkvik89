package com.todo.todo2.service;
import com.todo.todo2.model.Assignee;
import com.todo.todo2.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AssigneeService {

  private TodoService todoService;
  private com.todo.todo2.repository.iTodoRepository iTodoRepository;
  private com.todo.todo2.repository.iAssigneeRepository iAssigneeRepository;

  public AssigneeService(TodoService todoService, com.todo.todo2.repository.iTodoRepository iTodoRepository,
                         com.todo.todo2.repository.iAssigneeRepository iAssigneeRepository) {
    this.todoService = todoService;
    this.iTodoRepository = iTodoRepository;
    this.iAssigneeRepository = iAssigneeRepository;
    /*iAssigneeRepository.save(new Assignee(1, "Nagy Marcsi", "nagymarcsi@gmail.com"));
    iAssigneeRepository.save(new Assignee(1, "Béla bá", "belaba@freemail.hu"));
    iAssigneeRepository.save(new Assignee(1, "Sanyi a béka", "bekavagyok@gmail.com"));*/
  }

  public List<Todo> assigneeTaskList(Todo todo) {
    return iAssigneeRepository.findByTodosContains(todo);
  }
}
