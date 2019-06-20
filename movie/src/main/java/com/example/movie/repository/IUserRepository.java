package com.example.movie.repository;

import com.example.movie.model.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserProfile, Long>  {
  boolean existsByUserName (String userName);
  UserProfile findByUserName (String userName);
}
