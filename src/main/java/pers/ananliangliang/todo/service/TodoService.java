package pers.ananliangliang.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pers.ananliangliang.todo.domain.Todo;
import pers.ananliangliang.todo.repository.TodoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<Todo> getTodos() {

        return repository.findAll();
    }

    public Todo postTodo(String title, String comment) {
        final var todo = Todo.builder().title(title).comment(comment).build();
        repository.save(todo);
        return todo;
    }
}
