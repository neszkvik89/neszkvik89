package com.rest.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Log {

  @Id
  @GeneratedValue
  private int id;
  private String createdAt = "";
  private String endpoint = "";
  private String data = "";

  public Log() {
    Date date= new Date();
    long time = date.getTime();
    Timestamp ts = new Timestamp(time);
    this.createdAt = String.valueOf(ts);
  }

  public Log(String endpoint, String data) {
    Date date= new Date();
    long time = date.getTime();
    Timestamp ts = new Timestamp(time);
    this.createdAt = String.valueOf(ts);
    this.endpoint = endpoint;
    this.data = data;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
