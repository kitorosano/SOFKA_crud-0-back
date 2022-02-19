package co.com.sofka.crud0back.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
  
  @Id
  @GeneratedValue()
  private Long id;

  private String name;

  private boolean isCompleted;


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isIsCompleted() {
    return this.isCompleted;
  }

  public boolean getIsCompleted() {
    return this.isCompleted;
  }

  public void setIsCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

}
