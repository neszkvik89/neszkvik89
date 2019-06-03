package com.rest.rest.model;

public class Array {
  private String what = "";
  private int [] numbers = new int [4];

  public Array(String what, int[] numbers) {
    this.what = what;
    this.numbers = numbers;
  }

  public Array() {
  }

  public String getWhat() {
    return what;
  }

  public void setWhat(String what) {
    this.what = what;
  }

  public int[] getNumbers() {
    return numbers;
  }

  public void setNumbers(int[] numbers) {
    this.numbers = numbers;
  }
}
