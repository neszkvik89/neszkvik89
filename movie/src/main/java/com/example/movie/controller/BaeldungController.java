package com.example.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaeldungController {

  @GetMapping("/jwt-csrf-form")
  public String baeldung () {
    return "testform";
  }

}
