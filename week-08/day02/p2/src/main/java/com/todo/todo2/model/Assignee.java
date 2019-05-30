package com.todo.todo2.model;

import javax.persistence.*;

@Entity
@Table(name = "assignees")
public class Assignee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String email;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "todo_id")
  private Todo todo;

  public Assignee(long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Assignee() {
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Todo getTodo() {
    return todo;
  }

  public void setTodo(Todo todo) {
    this.todo = todo;
  }
}
