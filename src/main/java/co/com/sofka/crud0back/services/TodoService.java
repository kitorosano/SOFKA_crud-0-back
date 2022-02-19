package co.com.sofka.crud0back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.crud0back.models.Todo;
import co.com.sofka.crud0back.repositories.ITodoRepository;

@Service
public class TodoService {

  @Autowired
  private ITodoRepository todoRepository;

  /*=========== CREATE ===========*/
  public Todo save(Todo todo){
    return todoRepository.save(todo);
  }

  /*=========== READ ===========*/
  public Iterable<Todo> list(){
    return todoRepository.findAll();
  }

  public Todo get(Long id){
    return todoRepository.findById(id).orElseThrow();
  }


  /*=========== DELETE ===========*/
  public void delete(Long id){
    todoRepository.delete(this.get(id));
  }
  
}
