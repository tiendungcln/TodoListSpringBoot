package com.library.todolistspringboot.repository;

import com.library.todolistspringboot.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>  {

}
