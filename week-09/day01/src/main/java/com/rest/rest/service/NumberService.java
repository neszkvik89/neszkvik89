package com.rest.rest.service;

import com.rest.rest.model.Number;
import org.springframework.stereotype.Service;

@Service
public class NumberService {

  public NumberService() {
  }

  /*public Number doubleInt(int myNumber) {
    return new Number(myNumber, myNumber * 2);
  }*/

  public Number doAction (String action, int until) {
    int k = 0;
    if (action.equals("sum")) {
      for (int i = 1; i <= until; i++) {
        k += i;
      }
      return new Number(k);
    } else if (action.equals("factor")) {
      k++;
      for (int i = 1; i <= until; i++) {
        k *= i;
      }
      return new Number(k);
    } else return new Number(k);
  }

}
