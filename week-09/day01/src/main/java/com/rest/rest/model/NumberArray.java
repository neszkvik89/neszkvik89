package com.rest.rest.model;

public class NumberArray {
  private int [] result = new int [4];

  public NumberArray(int[] result) {
    this.result = result;
  }

  public NumberArray() {
  }

  public int[] getResult() {
    return result;
  }

  public void setResult(int[] result) {
    this.result = result;
  }
}
