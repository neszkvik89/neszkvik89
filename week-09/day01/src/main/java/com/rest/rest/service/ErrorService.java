package com.rest.rest.service;

import org.springframework.stereotype.Service;

@Service
public class ErrorService {

  public ErrorService() {
  }

  public String welcomeGenerator (String name, String title) {
    return "Oh, hi there " + name + ", my dear " + title + "!";
  }
}
