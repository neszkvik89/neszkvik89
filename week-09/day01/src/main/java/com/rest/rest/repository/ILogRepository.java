package com.rest.rest.repository;

import com.rest.rest.model.Log;
import org.springframework.data.repository.CrudRepository;

public interface ILogRepository extends CrudRepository <Log, String>{

}
