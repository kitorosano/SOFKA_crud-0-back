package co.com.sofka.crud0back.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.sofka.crud0back.models.Todo;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
  
}
