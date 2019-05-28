package com.todo.todo2.controller;

import com.todo.todo2.model.Todo;
import com.todo.todo2.repository.ITodoRepository;
import com.todo.todo2.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

  private ITodoRepository iTodoRepository;
  private TodoService todoService;

  @Autowired
  public TodoController(ITodoRepository iTodoRepository, TodoService iToDoService) {
    this.iTodoRepository = iTodoRepository;
    this.todoService = iToDoService;
  }

  @GetMapping("/todo")
  public String todo () {
    return "todo";
  }

  @GetMapping(value = {"/", "/list"})
  public String list (@RequestParam(name = "isActive", required = false) boolean isActive, Model model) {
    List<Todo> myTodos = new ArrayList<>();
    if (!isActive) {
      model.addAttribute("todos", iTodoRepository.findAll());
    } else {
      iTodoRepository.findAll().forEach(todo -> {if(!todo.isDone()) {
        myTodos.add(todo);
      }
      }
      );
      model.addAttribute("todos", myTodos);
    }
    return "todolist";
  }


}
