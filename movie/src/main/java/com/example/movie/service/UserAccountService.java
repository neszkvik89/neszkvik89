package com.example.movie.service;

import com.example.movie.GitHubService;
import com.example.movie.model.AccProfile;
import com.example.movie.model.RepoDetail;
import com.example.movie.repository.IAccProfileRepository;
import com.example.movie.repository.IRepoDetailRepository;
import io.jsonwebtoken.Claims;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

  @Autowired
  private GitHubService gitHubService;

  @Autowired
  private IRepoDetailRepository iRepoDetailRepository;

  @Autowired
  private IAccProfileRepository iAccProfileRepository;

  public AccProfile uaBuilder(Claims myClaim) {
    String jti = myClaim.getId();
    Date iat = myClaim.getIssuedAt();
    String sub = myClaim.getSubject();
    String iss = myClaim.getIssuer();
    Date exp = myClaim.getExpiration();

    return new AccProfile(jti, iat, sub, iss, exp);
  }

  public Object showReposWithValidToken(AccProfile userAccount) {

    if (iAccProfileRepository.existsByJti(userAccount.getJti())) {
      Date date = new Date();
      if (date.getTime() < iAccProfileRepository.findByJti(userAccount.getJti()).getExp()
          .getTime()) {
        List<RepoDetail> myRepos = new ArrayList<>();
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
      return "Token expired";
    }
    return "Token expired";
  }
}
