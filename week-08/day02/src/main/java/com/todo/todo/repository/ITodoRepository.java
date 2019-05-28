package com.todo.todo.repository;

import com.todo.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {

}
