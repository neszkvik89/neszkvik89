package com.rest.rest.service;

import com.rest.rest.model.Error;
import com.rest.rest.model.Number;
import com.rest.rest.model.NumberArray;
import org.springframework.stereotype.Service;

@Service
public class ArrayService {

  public ArrayService() {
  }

  public Object handleArray (String what, int [] numbers) {
    if (what != null && numbers != null) {
      if (what.equals("sum")) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
          sum += numbers[i];
        }
        return new Number(sum);
      } else if (what.equals("multiply")) {
        int sum = 1;
        for (int i = 0; i < numbers.length; i++) {
          sum *= numbers[i];
        }
        return new Number(sum);
      } else if (what.equals("double")) {
        int[] myArray = new int[4];
        for (int i = 0; i < numbers.length; i++) {
          myArray[i] = numbers[i] * 2;
        }
        return new NumberArray(myArray);
      }
    }
    return new Error("Please provide what to do with the numbers!");
  }
}

