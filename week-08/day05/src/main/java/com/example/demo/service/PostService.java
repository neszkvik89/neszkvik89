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

  public void increaseScore (Long id) {
    Post myPost = iPostRepository.findById(id).orElseGet(null);
    myPost.scorePlusOne();
    iPostRepository.save(myPost);
  }

  public void decreaseScore (Long id) {
    Post myPost = iPostRepository.findById(id).orElseGet(null);
    myPost.scoreMinusOne();
    iPostRepository.save(myPost);
  }

  //ide jön a method, ami csinál is valamit
}
