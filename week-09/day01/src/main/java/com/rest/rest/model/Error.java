package com.rest.rest.model;

public class Error {
  private String error = "Please provide an input!";

  public Error() {
  }

  public Error(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
