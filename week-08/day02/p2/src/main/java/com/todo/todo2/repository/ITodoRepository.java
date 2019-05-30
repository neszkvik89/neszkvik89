package com.todo.todo2.repository;

import com.todo.todo2.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findByTitleContainingOrContentContaining(String title, String content);


}
