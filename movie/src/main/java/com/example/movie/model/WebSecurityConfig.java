package com.example.movie.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
