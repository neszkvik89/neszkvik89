package com.example.movie.controller;

import static com.example.movie.JWTDemo.createJWT;
import static com.example.movie.JWTDemo.decodeJWT;

import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubController {

  @GetMapping("/sub")
  public Claims subTest () {
    return decodeJWT(createJWT("1234", "FBI", "John", 1234567898991L));
  }
}
