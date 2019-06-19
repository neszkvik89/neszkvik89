package com.example.movie.controller;


import com.example.movie.JWTDemo;
import com.example.movie.config.JWTCsrfTokenRepository;
import com.example.movie.model.UserProfile;
import com.example.movie.repository.IUserRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {

  private IUserRepository iUserRepository;
  private JWTCsrfTokenRepository jwtCsrfTokenRepository;

  @Autowired
  public RegController(IUserRepository iUserRepository) {
    this.iUserRepository = iUserRepository;
  }

  @GetMapping("/register")
  public String loadRegPage() {
    return "register";
  }

  @PostMapping("/register")
  public String doRegistration (String userName, String password) {
    if (!iUserRepository.existsByUserName(userName)) {
      iUserRepository.save(new UserProfile(userName, password));
    }
    return "login";
  }

  @PostMapping("login")
  public String doLogin (String userName, String password) {
    String myToken;
    if (iUserRepository.findByUserName(userName).getPassword().equals(password)) {
      myToken = JWTDemo.createJWT(String.valueOf(iUserRepository.findByUserName(userName).getId()),
          "FBI", userName);
      System.out.println();
    }
    return "index";
  }

  /*@GetMapping("/secret")
  public String shareSecret(HttpServletRequest req) {
    req.
  }*/

}
