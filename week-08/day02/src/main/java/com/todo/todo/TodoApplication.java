package com.todo.todo;

import com.todo.todo.model.Todo;
import com.todo.todo.repository.ITodoRepository;
import com.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(TodoApplication.class, args);
  }

  private ITodoRepository iTodoRepository;

  @Autowired
  public TodoApplication(ITodoRepository iTodoRepository) {
    this.iTodoRepository = iTodoRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    iTodoRepository.save(new Todo(1, "Learn stuff", false, false));
    iTodoRepository.save(new Todo(1, "Sleep", false, false));
    iTodoRepository.save(new Todo(1, "Eat", false, false));
    iTodoRepository.save(new Todo(1, "Repeat", false, false));

  }
}
