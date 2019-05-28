package com.todo.todo.controller;

import com.todo.todo.repository.ITodoRepository;
import com.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
  public String list (Model model) {
    model.addAttribute("todos", iTodoRepository.findAll());
    return "todolist";
  }


}
