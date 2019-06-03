package com.rest.rest.controller;

import com.rest.rest.model.*;
import com.rest.rest.model.Error;
import com.rest.rest.model.Number;
import com.rest.rest.service.AppendService;
import com.rest.rest.service.ArrayService;
import com.rest.rest.service.ErrorService;
import com.rest.rest.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OtherController {

  private NumberService numberService;
  private ErrorService errorService;
  private AppendService appendService;
  private ArrayService arrayService;

  @Autowired
  public OtherController(NumberService numberService, ErrorService errorService, AppendService appendService, ArrayService arrayService) {
    this.numberService = numberService;
    this.errorService = errorService;
    this.appendService = appendService;
    this.arrayService = arrayService;
  }


  /*@GetMapping("/doubling")
  public Object intDoubler(@RequestParam(name = "input", required = false) Integer input) {
    if (input != null) {
      return numberService.doubleInt(input);
    } else {
      return new Error();
    }
  }*/

  @GetMapping("/greeter")
  public Object greeter(@RequestParam(name = "name", required = false) String name,
                        @RequestParam(name = "title", required = false) String title) {

    if (name != null && title != null) {
      return new Message(errorService.welcomeGenerator(name, title));
    } else if (name == null && title == null) {
      return new Error("Please provide a name and a title!");
    } else if (name == null) {
      return new Error("Please provide a name!");
    } else {
      return new Error("Please provide a title!");
    }
  }

  @GetMapping("/appenda/{appendable}")
  public Object appender (@PathVariable ("appendable") String appendable) {
    return appendService.appendChar(appendable);
  }

  @PostMapping("/dountil/{action}")
  public Object doUntil (@PathVariable("action") String action,
                         @RequestBody Until until) {
    if (action != null && until != null) {
      return numberService.doAction(action, until.getUntil());
    } else {
     return new Error("Please provide a number!");
    }
  }

  @PostMapping("/arrays")
  public Object handleArray (@RequestBody Array array) {
    return arrayService.handleArray(array.getWhat(), array.getNumbers());
  }
}


