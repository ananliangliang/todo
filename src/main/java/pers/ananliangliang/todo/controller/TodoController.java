package pers.ananliangliang.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pers.ananliangliang.todo.domain.Todo;
import pers.ananliangliang.todo.domain.form.PostTodoForm;
import pers.ananliangliang.todo.service.TodoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos(Authentication authentication) {
        List<Todo> todos = service.getTodos();
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> postTodo(@RequestBody @Valid PostTodoForm form) {
        Todo todo = service.postTodo(form.getTitle(), form.getComment());
        return ResponseEntity.ok(todo);
    }

}
