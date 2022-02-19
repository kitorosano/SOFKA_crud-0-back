package co.com.sofka.crud0back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.crud0back.models.Todo;
import co.com.sofka.crud0back.services.TodoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoController {

  @Autowired
  private TodoService todoService;

   /*=========== CREATE ===========*/
   @PostMapping(value = "api/todo")
   public Todo save(@RequestBody Todo todo){
    return todoService.save(todo);
  }

  /*=========== READ ===========*/
   @GetMapping(value = "api/todos")
  public Iterable<Todo> list(){
    return todoService.list();
  }

  @GetMapping(value = "api/{id}/todo")
  public Todo get(@PathVariable("id") Long id){
    return todoService.get(id);
  }

  /*=========== UPDATE ===========*/
  @PutMapping(value = "api/todo")
   public Todo update(@RequestBody Todo todo){
     if(todo.getId() != null)
      return todoService.save(todo);

      throw new RuntimeException("No existe el id para actualizar");
  }

  /*=========== DELETE ===========*/
  @DeleteMapping(value = "api/{id}/todo")
  public void delete(@PathVariable("id") Long id){
    todoService.delete(id);
  }
  
}
