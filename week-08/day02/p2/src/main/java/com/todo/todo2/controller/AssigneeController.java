package com.todo.todo2.controller;
import com.todo.todo2.model.Assignee;
import com.todo.todo2.model.Todo;
import com.todo.todo2.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AssigneeController {
  private TodoService todoService;
  private com.todo.todo2.repository.iTodoRepository iTodoRepository;
  private com.todo.todo2.repository.iAssigneeRepository iAssigneeRepository;

  @Autowired
  public AssigneeController(TodoService todoService, com.todo.todo2.repository.iTodoRepository iTodoRepository,
                            com.todo.todo2.repository.iAssigneeRepository iAssigneeRepository) {
    this.todoService = todoService;
    this.iTodoRepository = iTodoRepository;
    this.iAssigneeRepository = iAssigneeRepository;
  }

  @GetMapping("/assigneeList")
  public String assigneeList (Model model) {
    model.addAttribute("assignees", iAssigneeRepository.findAll());
    return "assigneelist";
  }

  @PostMapping (value = "/{id}/{email}/changeName")
  public String changeName (@PathVariable("id") long id, @PathVariable("email") String email, String name, Model model) {
    Assignee myAssignee = new Assignee();
    myAssignee.setName(name);
    myAssignee.setId(id);
    myAssignee.setEmail(email);
    iAssigneeRepository.save(myAssignee);
    model.addAttribute("assignees", iAssigneeRepository.findAll());
    return "assigneelist";
  }

  @PostMapping (value = "/{id}/removeAssignee")
  public String removeAssignee (@PathVariable("id") long id, Model model) {
    iAssigneeRepository.deleteById(id);
    model.addAttribute("assignees", iAssigneeRepository.findAll());
    return "assigneelist";
  }


  @PostMapping (value = "/newAssignee")
  public String addAssignee(String newName, String email, Model model) {
    iAssigneeRepository.save(new Assignee(newName, email));
    model.addAttribute("assignees", iAssigneeRepository.findAll());
    return "assigneelist";
  }

  @PostMapping(value = "/{id}/assign")
  public String edit(@PathVariable("id") long id, long assId, Model model) {
    Todo myTodo;
    myTodo = iTodoRepository.findById(id).orElseGet(null);
    myTodo.setTodoAssignee(iAssigneeRepository.findById(assId).orElseGet(null).getName());
    iTodoRepository.save(myTodo);

    Assignee myAssignee;
    myAssignee = iAssigneeRepository.findById(assId).orElseGet(null);
    myAssignee.getTodos().add(myTodo);
    iAssigneeRepository.save(myAssignee);
    model.addAttribute("todos", iTodoRepository.findAll());
    model.addAttribute("assignees", iAssigneeRepository.findAll());
    return "todolist";
  }

  @PostMapping(value = "/{id}/profile")
  public String edit(@PathVariable("id") long id, Model model) {
    model.addAttribute("todos", iAssigneeRepository
            .findById(id).orElseGet(null).getTodos());
    return "profile";
  }
}
