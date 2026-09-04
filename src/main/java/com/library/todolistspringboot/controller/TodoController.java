package com.library.todolistspringboot.controller;

import com.library.todolistspringboot.entity.Todo;
import com.library.todolistspringboot.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id){
        return todoService.getById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTodo(@PathVariable Long id){
        return todoService.deleteTodo(id);
    }

}
