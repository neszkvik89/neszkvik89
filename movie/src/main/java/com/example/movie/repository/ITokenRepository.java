package com.example.movie.repository;

import com.example.movie.model.AccProfile;
import org.springframework.data.repository.CrudRepository;

public interface ITokenRepository extends CrudRepository<AccProfile, Long> {

  public boolean existsByJti(String jti);
  public AccProfile findByJti (String jti);

}
