package com.todo.todo2.repository;

import com.todo.todo2.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {

}
