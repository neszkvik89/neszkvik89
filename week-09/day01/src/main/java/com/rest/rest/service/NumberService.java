package com.rest.rest.service;

import com.rest.rest.model.Number;
import org.springframework.stereotype.Service;

@Service
public class NumberService {

  public NumberService() {
  }

  public Number doubleInt (int myNumber) {
    return new Number(myNumber, myNumber *2);
  }

}
