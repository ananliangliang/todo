package pers.ananliangliang.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pers.ananliangliang.todo.domain.Task;
import pers.ananliangliang.todo.domain.form.PostTodoForm;
import pers.ananliangliang.todo.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTodos(Authentication authentication) {
        List<Task> tasks = service.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/tasks")
    public ResponseEntity<Task> postTask(@RequestBody @Valid PostTodoForm form) {
        Task task = service.postTask(form.getTitle(), form.getComment());
        return ResponseEntity.ok(task);
    }

}
