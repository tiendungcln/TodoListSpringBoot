package com.library.todolistspringboot.service;

import com.library.todolistspringboot.entity.Todo;
import com.library.todolistspringboot.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo getById(Long id){
        return todoRepository.findById(id).orElse(null);
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todo){
        Todo existingTodo = todoRepository.findById(id).orElse(null);

        if (existingTodo == null){
            return null;
        }

        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setCompleted(todo.isCompleted());

        return todoRepository.save(existingTodo);
    }

    public boolean deleteTodo(Long id){
        if (!todoRepository.existsById(id)){
            return false;
        }

        todoRepository.deleteById(id);
        return true;
    }

}
