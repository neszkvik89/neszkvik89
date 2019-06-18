package com.example.movie.repository;

import com.example.movie.model.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserProfile, Long>  {
  public boolean existsByUserName (String userName);
  public UserProfile findByUserName (String userName);
}
