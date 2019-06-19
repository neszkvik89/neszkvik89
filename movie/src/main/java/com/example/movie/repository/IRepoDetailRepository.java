package com.example.movie.repository;

import com.example.movie.model.RepoDetail;
import org.springframework.data.repository.CrudRepository;

public interface IRepoDetailRepository extends CrudRepository<RepoDetail, Long> {

  public RepoDetail findById(long id);

}
