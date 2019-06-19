package com.example.movie.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RepoDetail {

  @Id
  private long id;
  private String name;

  public RepoDetail(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public RepoDetail() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
