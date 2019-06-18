package com.example.movie.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  CsrfTokenRepository jwtCsrfTokenRepository;

  private String[] ignoreCsrfAntMatchers = {
      "/dynamic-builder-compress",
      "/dynamic-builder-general",
      "/dynamic-builder-specific",
      "/set-secrets"};


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf()
        .ignoringAntMatchers(ignoreCsrfAntMatchers)
        .and().authorizeRequests()
        .antMatchers("/**")
        .permitAll();
  }
}
