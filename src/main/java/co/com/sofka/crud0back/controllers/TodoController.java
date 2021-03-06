package co.com.sofka.crud0back.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  /**
  * Metodo para obtener todos los objetos TODO. Se puede utilizar el parametro name o completed opcionalmente para filtrar por nombre o estado
  * @param name
  * @param completed
  * @return Un response exitoroso con la lista de los TODOs o aquellos filtrados por nombre o estado, o un response vacio. 
  */
  @GetMapping(value = "/todos")
  public ResponseEntity<List<TodoModel>> readTodos(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "completed", required = false) Boolean completed){
    try {
      List<TodoModel> todos = todoService.findTodos(name, completed);
      
      if(todos.isEmpty())
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      
      
      return new ResponseEntity<>(todos, HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  /**
  * Metodo para obtener un objeto TODO mediante su id
  * @param id
  * @return Un response exitoroso con el TODO, o un response vacio.
  */
  @GetMapping("/todos/{id}")
  public ResponseEntity<TodoModel> readTodo(@PathVariable(value = "id") Long id) {
    Optional<TodoModel> todo = todoService.getTodo(id);
    
    if (todo.isPresent()) {
      return new ResponseEntity<>(todo.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  /*=========== UPDATE ===========*/
  
  /**
  * Metodo para modificar un objeto TODO mediante su id
  * @param id
  * @param todo
  * @return Un response exitoso con el TODO modificado, o un response vacio
  */
  @PutMapping("/todos/{id}")
  public ResponseEntity<TodoModel> updateTodo(@PathVariable(value = "id") Long id, @RequestBody TodoModel todo){
    try {
      TodoModel todoData = todoService.editTodo(id, todo);
      
      return new ResponseEntity<>(todoData, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  } 
  
  /*=========== DELETE ===========*/
  
  /**
  * Metodo para eliminar un TODO mediante su id
  * @param id
  * @return Un response exitoso con un mensaje si se ha eliminado correctamente, o un response fallido.
  */
  @DeleteMapping("/todos/{id}")
  public ResponseEntity<String> deleteTodo(@PathVariable(value = "id") long id) {
    try {
      todoService.deleteTodo(id);
      return new ResponseEntity<>("TODO has been deleted sucessfully",HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
  }
  
  /**
  * Metodo para eliminar TODOs mediante su titulo
  * @param completed
  * @return Un response exitoso con un mensaje si se han eliminado correctamente, o un response fallido.
  */
  @DeleteMapping(value = "/todos")
  public ResponseEntity<String> deleteTodos(@RequestParam(value = "completed", required = false) Boolean completed) {
    try {
      todoService.deleteTodos(completed);
      return new ResponseEntity<>("TODOs deleted sucessfully",HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
  }
}
