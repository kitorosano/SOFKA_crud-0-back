package co.com.sofka.crud0back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.crud0back.models.TodoModel;
import co.com.sofka.crud0back.repositories.ITodoRepository;

@Service
public class TodoService {

  @Autowired
  private ITodoRepository todoRepository;

  /*=========== SAVE ===========*/
  public TodoModel saveTodo(TodoModel todo){
    return todoRepository.save(new TodoModel(todo.getName(), false));
  }

  /*=========== FIND ===========*/
  /** Find all TODOs. Find all TODOs by name */
  public List<TodoModel> findTodos(String name){
    if(name == null) return (List<TodoModel>) todoRepository.findAll();
    return todoRepository.findByNameContaining(name);
  }

  /** Get TODO by id */
  public Optional<TodoModel> getTodo(Long id){
    return todoRepository.findById(id);
  }


  /*=========== DELETE ===========*/
  public void delete(Long id){
    todoRepository.delete(this.getTodo(id).get());
  }
  
}
