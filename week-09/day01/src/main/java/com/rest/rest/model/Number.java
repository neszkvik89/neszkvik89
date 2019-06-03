package com.rest.rest.model;

public class Number {

  private int received;
  private int result;

  public Number() {
  }

  public Number(int received, int result) {
    this.received = received;
    this.result = result;
  }

  public int getReceived() {
    return received;
  }

  public void setReceived(int received) {
    this.received = received;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
