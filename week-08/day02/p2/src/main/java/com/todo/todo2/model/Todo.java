package com.todo.todo2.model;

import javax.persistence.*;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String title;
  private String content;
  private String todoAssignee = "Not yet assigned";
  private boolean urgent = false;
  private boolean done = false;

  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn(name = "assignee_id")
  private Assignee assignee;

  public Todo() {
  }

  public Todo(long id, String title, String content, boolean urgent, boolean done) {
    this.id = id;
    this.title = title;
    this.urgent = urgent;
    this.done = done;
    this.content = content;
  }

  public Todo(String title) {
    this.title = title;
  }

  public String getTodoAssignee() {
    return todoAssignee;
  }

  public void setTodoAssignee(String todoAssignee) {
    this.todoAssignee = todoAssignee;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isUrgent() {
    return urgent;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }
}
