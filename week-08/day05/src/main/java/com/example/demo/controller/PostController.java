package com.example.demo.controller;

import com.example.demo.repository.IPostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
  private IPostRepository iPostRepository;
  private PostService postService;

  @Autowired
  public PostController(IPostRepository iPostRepository, PostService postService) {
    this.iPostRepository = iPostRepository;
    this.postService = postService;
  }

  @GetMapping("/")
  public String index (Model model) {
    model.addAttribute("posts", iPostRepository.findAll());
    return "main";
  }
}
