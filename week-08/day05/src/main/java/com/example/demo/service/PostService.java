package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.IPostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  private IPostRepository iPostRepository;

  public PostService(IPostRepository iPostRepository) {
    this.iPostRepository = iPostRepository;
  }

  //ide jön a method, ami csinál is valamit
}
