package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.repository.IPostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

  @GetMapping("/upvote/{id}")
  public String upvote(@PathVariable ("id") long id, Model model) {
    Post myPost = iPostRepository.findById(id).orElseGet(null);
    myPost.setUpvotes(myPost.getUpvotes() + 1);
    iPostRepository.save(myPost);
    model.addAttribute("posts", iPostRepository.findAll());
    return "main";
  }

  @GetMapping("/downvote/{id}")
  public String downvote(@PathVariable ("id") long id, Model model) {
    Post myPost = iPostRepository.findById(id).orElseGet(null);
    myPost.setUpvotes(myPost.getUpvotes() - 1);
    iPostRepository.save(myPost);
    model.addAttribute("posts", iPostRepository.findAll());
    return "main";
  }

  @GetMapping("/commit")
  public String commit() {
    return "commit";
  }

  @PostMapping("/commit")
  public String newCommit(Model model, String title, String url) {
    iPostRepository.save(new Post(title, url));
    model.addAttribute("posts", iPostRepository.findAll());
    return "main";
  }
}
