package com.todo.todo2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assignees")
public class Assignee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String email;


  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "todo_id")
  private List<Todo> todos;

  public Assignee(long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
    todos = new ArrayList<>();
  }

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
    todos = new ArrayList<>();
  }

  public Assignee() {
    todos = new ArrayList<>();
  }



  public List<Todo> getTodos() {
    return todos;
  }

  public void setTodos(List<Todo> todos) {
    this.todos = todos;
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

}
