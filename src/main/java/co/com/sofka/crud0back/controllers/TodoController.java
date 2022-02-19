package co.com.sofka.crud0back.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.crud0back.models.TodoModel;
import co.com.sofka.crud0back.services.TodoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TodoController {

  @Autowired
  private TodoService todoService;

   /*=========== CREATE ===========*/
   /**
   * Metodo para crear un nuevo objeto Todo, utilizando el modelo del body del request.
   * @param todo
   * @return Un response exitoroso con el nuevo objeto creado, o un response fallido.
   */
  @PostMapping(value = "/todos")
  public ResponseEntity<TodoModel> createTodo(@RequestBody TodoModel todo){
    try {
      return new ResponseEntity<>(todoService.saveTodo(todo), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
  }

  /*=========== READ ===========*/
   @GetMapping(value = "/todos")
  public Iterable<TodoModel> list(){
    return todoService.list();
  }

  @GetMapping(value = "/todos", params = "id")
  public TodoModel get(@PathParam("id") Long id){
    return todoService.get(id);
  }

  /*=========== UPDATE ===========*/
  @PutMapping(value = "/todos")
   public TodoModel update(@RequestBody TodoModel todo){
     if(todo.getId() != null)
      return todoService.saveTodo(todo);

      throw new RuntimeException("No existe el id para actualizar");
  }

  /*=========== DELETE ===========*/
  @DeleteMapping(value = "/todos")
  public void delete(@PathVariable("id") Long id){
    todoService.delete(id);
  }
  
}
