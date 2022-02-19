package co.com.sofka.crud0back.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoModel {
  
  @Id
  @GeneratedValue()
  private Long id;

  @Column(name = "name", length = 40, nullable = false)
  private String name;
  
  @Column(name = "completed", nullable = false)
  private Boolean completed;


  public TodoModel() {
  }

  public TodoModel(String name, Boolean completed) {
    this.name = name;
    this.completed = completed;
  }

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

  public Boolean isCompleted() {
    return this.completed;
  }

  public Boolean getCompleted() {
    return this.completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TodoModel)) {
            return false;
        }
        TodoModel todoModel = (TodoModel) o;
        return Objects.equals(id, todoModel.id) && Objects.equals(name, todoModel.name) && completed == todoModel.completed;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, completed);
  }
  

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", completed='" + isCompleted() + "'" +
      "}";
  }

}
