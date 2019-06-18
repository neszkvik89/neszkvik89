package com.example.movie.controller;

import static com.example.movie.JWTDemo.createJWT;
import static com.example.movie.JWTDemo.decodeJWT;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubController {

  @GetMapping("/jwt-csrf-form")
  public String subTest () {
    return "testform";
  }
}
