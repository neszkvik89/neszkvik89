package com.todo.todo2.repository;

import com.todo.todo2.model.Assignee;
import com.todo.todo2.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface iAssigneeRepository extends CrudRepository<Assignee, Long> {
  List<Todo> findByTodosContains(Todo todo);
}
