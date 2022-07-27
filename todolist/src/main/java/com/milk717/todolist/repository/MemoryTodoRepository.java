package com.milk717.todolist.repository;

import com.milk717.todolist.domain.Todo;

import java.util.*;

public class MemoryTodoRepository implements TodoRepository{

    private static Map<Long,Todo> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Todo save(Todo todo) {
        todo.setId(++sequence);
        todo.setCreateAt(new Date());
        store.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Boolean deleteById(Long id) {
        Optional.ofNullable(store.remove(id))
    }

    @Override
    public Optional<Todo> checkById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }
}
