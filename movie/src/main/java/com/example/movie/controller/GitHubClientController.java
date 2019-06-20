package com.example.movie.controller;

import com.example.movie.GitHubService;
import com.example.movie.model.RepoDetail;
import com.example.movie.repository.IRepoDetailRepository;
import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.event.DeletePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GitHubClientController {


  @Autowired
  private GitHubService githubService;

  @Autowired
  private IRepoDetailRepository iRepoDetailRepository;

  @PostMapping("/repos")
  public List<RepoDetail> getRepos(@PathVariable ("token") String token) throws IOException {

    List<RepoDetail> myRepos = new ArrayList<>();

    githubService.getRepositories().
        forEach(p -> iRepoDetailRepository.
            save(new RepoDetail(p.getId(), p.getName())));
    

    iRepoDetailRepository.findAll().forEach(p -> myRepos.add(p));

    return myRepos;
  }

  /*@PostMapping("/repos")
  public Repository createRepo(@RequestBody Repository newRepo) throws IOException {
    return githubService.createRepository(newRepo);
  }*/

  @DeleteMapping("/repos/{owner}/{repo}")
  public DeletePayload deleteRepo(
      @PathVariable("owner") String owner,
      @PathVariable("repo") String repoName) throws IOException {
    return githubService.deleteRepository(owner, repoName);
  }
}
