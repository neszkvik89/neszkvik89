package com.example.movie.service;

import com.example.movie.GitHubService;
import com.example.movie.JWTDemo;
import com.example.movie.model.AccProfile;
import com.example.movie.model.RepoDetail;
import com.example.movie.repository.ITokenRepository;
import com.example.movie.repository.IRepoDetailRepository;
import io.jsonwebtoken.Claims;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

  @Autowired
  private GitHubService gitHubService;

  @Autowired
  private IRepoDetailRepository iRepoDetailRepository;

  @Autowired
  private ITokenRepository iTokenRepository;

  @Autowired
  private UserAccountService userAccountService;

  public AccProfile uaBuilder(Claims myClaim) {
    String jti = myClaim.getId();
    Date iat = myClaim.getIssuedAt();
    String sub = myClaim.getSubject();
    String iss = myClaim.getIssuer();
    Date exp = myClaim.getExpiration();

    return new AccProfile(jti, iat, sub, iss, exp);
  }

  public List<RepoDetail> showReposWithValidToken(AccProfile userAccount) {

    List<RepoDetail> myRepos = new ArrayList<>();
    if (iTokenRepository.existsByJti(userAccount.getJti())) {
      Date date = new Date();
      if (date.getTime() < iTokenRepository.findByJti(userAccount.getJti()).getExp()
          .getTime()) {
        try {
          gitHubService.getRepositories().
              forEach(p -> iRepoDetailRepository.
                  save(new RepoDetail(p.getId(), p.getName())));

          iRepoDetailRepository.findAll().forEach(p -> myRepos.add(p));
        } catch (IOException e) {
          e.printStackTrace();
        }
        return myRepos;
      }
      return myRepos;
    }
    return myRepos;
  }

  public List<RepoDetail> show12ReposWithValidToken (AccProfile userAccount) {
    List<RepoDetail> myRepos = new ArrayList<>();
    if (iTokenRepository.existsByJti(userAccount.getJti())) {
      Date date = new Date();
      if (date.getTime() < iTokenRepository.findByJti(userAccount.getJti()).getExp()
          .getTime()) {
        myRepos = userAccountService.showReposWithValidToken(userAccount)
            .stream()
            .filter(p -> String.valueOf(p.getId()).startsWith("12"))
            .collect(Collectors.toList());
        }
        return myRepos;
      }
      return myRepos;
    }
}
