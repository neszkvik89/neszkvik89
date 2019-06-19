package com.example.movie.repository;

import com.example.movie.model.AccProfile;
import org.springframework.data.repository.CrudRepository;

public interface IUserAccountRepository extends CrudRepository<AccProfile, Long> {

}
