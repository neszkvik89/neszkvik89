package com.example.movie.repository;

import com.example.movie.model.AccProfile;
import org.springframework.data.repository.CrudRepository;

public interface ITokenRepository extends CrudRepository<AccProfile, Long> {

  boolean existsByJti(String jti);
  AccProfile findByJti (String jti);

}
