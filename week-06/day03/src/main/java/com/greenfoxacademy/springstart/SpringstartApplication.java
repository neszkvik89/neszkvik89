package com.greenfoxacademy.springstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SpringstartApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringstartApplication.class, args);
    }

    public String hello () {
        return "Hello World!";
    }


}