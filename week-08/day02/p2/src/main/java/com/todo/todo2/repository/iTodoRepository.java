package com.todo.todo2.repository;

import com.todo.todo2.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface iTodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findByTitleContainingOrContentContaining(String title, String content);


}
