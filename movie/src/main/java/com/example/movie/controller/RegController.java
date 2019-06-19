package com.example.movie.controller;


import com.example.movie.JWTDemo;
import com.example.movie.config.JWTCsrfTokenRepository;
import com.example.movie.model.UserProfile;
import com.example.movie.repository.IUserAccountRepository;
import com.example.movie.repository.IUserRepository;
import com.example.movie.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegController {

  private IUserRepository iUserRepository;
  private JWTCsrfTokenRepository jwtCsrfTokenRepository;
  private IUserAccountRepository iUserAccountRepository;
  private UserAccountService userAccountService;

  @Autowired
  public RegController(IUserRepository iUserRepository,
      IUserAccountRepository iUserAccountRepository, UserAccountService userAccountService) {
    this.iUserRepository = iUserRepository;
    this.iUserAccountRepository = iUserAccountRepository;
    this.userAccountService = userAccountService;
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
      iUserAccountRepository.save(userAccountService.uaBuilder(JWTDemo.decodeJWT(myToken)));

      System.out.println(myToken);
      System.out.println(JWTDemo.decodeJWT(myToken));
    }
    return "index";
  }

  /*@PostMapping ("/secret")
  public String shareSecret(@RequestBody AccProfile userAccount) {

  }*/

}
