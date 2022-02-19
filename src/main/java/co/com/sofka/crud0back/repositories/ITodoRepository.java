package co.com.sofka.crud0back.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.sofka.crud0back.models.TodoModel;

public interface ITodoRepository extends CrudRepository<TodoModel, Long> {

	List<TodoModel> findByNameContaining(String name);
  
}
