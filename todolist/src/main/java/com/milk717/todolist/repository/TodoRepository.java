package com.milk717.todolist.repository;

import com.milk717.todolist.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo save(Todo todo);
    Boolean deleteById(Long id);
    Optional<Todo> checkById(Long id);
    List<Todo> findAll();
}
