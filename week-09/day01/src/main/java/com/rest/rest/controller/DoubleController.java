package com.rest.rest.controller;

import com.rest.rest.model.Error;
import com.rest.rest.model.Number;
import com.rest.rest.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoubleController {

  private NumberService numberService;

  @Autowired
  public DoubleController(NumberService numberService) {
    this.numberService = numberService;
  }


  @GetMapping("/doubling")
  public Object intDoubler (@RequestParam (name = "input", required = false) Integer input) {
    if (input != null) {
      return numberService.doubleInt(input);
    } else {
      return new Error();
    }

  }
}
