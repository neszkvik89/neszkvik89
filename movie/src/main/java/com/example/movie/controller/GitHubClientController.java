package com.example.movie.controller;

import com.example.movie.GitHubService;
import com.example.movie.JWTHandler;
import com.example.movie.model.RepoDetail;
import com.example.movie.repository.ITokenRepository;
import com.example.movie.repository.IRepoDetailRepository;
import com.example.movie.service.UserAccountService;
import java.util.List;
import org.eclipse.egit.github.core.event.DeletePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GitHubClientController {


  @Autowired
  private GitHubService githubService;

  @Autowired
  private IRepoDetailRepository iRepoDetailRepository;

  @Autowired
  private UserAccountService userAccountService;

  @Autowired
  private ITokenRepository iTokenRepository;


  @PostMapping("/repos/{token}")
  public List<RepoDetail> getRepos(@PathVariable ("token") String token) throws IOException {

    return userAccountService.showAllReposWithValidToken(iTokenRepository.
        findByJti(JWTHandler.decodeJWT(token).getId()));

  }

  @PostMapping("/repos12/{token}")
  public Object get12Repos(@PathVariable ("token") String token) throws IOException {

    return userAccountService.showIdStartsWith12ReposWithValidToken(iTokenRepository.
        findByJti(JWTHandler.decodeJWT(token).getId()));

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
