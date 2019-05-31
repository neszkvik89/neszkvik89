package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private int upvotes;
  private String title;
  private String url;
  private String timeStamp;

  public void scorePlusOne () {
    this.setUpvotes(this.getUpvotes() + 1);
  }

  public void scoreMinusOne () {
    this.setUpvotes(this.getUpvotes() - 1);
  }

  public Post() {
    Date date= new Date();
    long time = date.getTime();
    Timestamp ts = new Timestamp(time);
    this.timeStamp = String.valueOf(ts);
  }

  public Post(String title, String url) {
    this.title = title;
    this.url = url;
    Date date= new Date();
    long time = date.getTime();
    Timestamp ts = new Timestamp(time);
    this.timeStamp = String.valueOf(ts);
  }

  public Post(int upvotes, String title, String url) {
    this.upvotes = upvotes;
    this.title = title;
    this.url = url;
    Date date= new Date();
    long time = date.getTime();
    Timestamp ts = new Timestamp(time);
    this.timeStamp = String.valueOf(ts);
  }

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getUpvotes() {
    return upvotes;
  }

  public void setUpvotes(int upvotes) {
    this.upvotes = upvotes;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
