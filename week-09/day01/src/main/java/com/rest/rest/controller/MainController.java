package com.rest.rest.controller;

import com.rest.rest.repository.ILogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  private ILogRepository iLogRepository;

  @Autowired
  public MainController(ILogRepository iLogRepository) {
    this.iLogRepository = iLogRepository;
  }

  @GetMapping("/")
  public String index () {
    return "index";
  }

  @GetMapping("/log")
  public String log (Model model) {
    model.addAttribute("logs", iLogRepository.findAll());
    return "log";
  }
}

