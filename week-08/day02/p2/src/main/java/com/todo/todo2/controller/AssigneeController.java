package com.todo.todo2.controller;
import com.todo.todo2.model.Assignee;
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
}
