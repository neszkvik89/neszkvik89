package com.example.movie.controller;


import com.example.movie.JWTDemo;
import com.example.movie.config.JWTCsrfTokenRepository;
import com.example.movie.model.AccProfile;
import com.example.movie.model.UserProfile;
import com.example.movie.repository.ITokenRepository;
import com.example.movie.repository.IUserRepository;
import com.example.movie.service.UserAccountService;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class RegController {


  private IUserRepository iUserRepository;
  private ITokenRepository iTokenRepository;
  private UserAccountService userAccountService;
  private BCryptPasswordEncoder bCryptPasswordEncoder;


  @Autowired
  public RegController(IUserRepository iUserRepository,
      ITokenRepository iTokenRepository, UserAccountService userAccountService,
      BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.iUserRepository = iUserRepository;
    this.iTokenRepository = iTokenRepository;
    this.userAccountService = userAccountService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @GetMapping("/register")
  public String loadRegPage() {
    return "register";
  }

  @PostMapping("/register")
  public String doRegistration(String userName, String password) {
    if (!iUserRepository.existsByUserName(userName)) {
      iUserRepository.save(new UserProfile(userName, bCryptPasswordEncoder.encode(password)));
    }
    return "login";
  }

  @PostMapping("login")
  public String doLogin(String userName, String password, Model model) {
    model.addAttribute("token", userAccountService.loginAndSaveToken(password, userName));
    return "index";
  }
}
