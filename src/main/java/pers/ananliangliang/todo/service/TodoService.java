package pers.ananliangliang.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pers.ananliangliang.todo.domain.Task;
import pers.ananliangliang.todo.repository.TodoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<Task> getTasks() {

        return repository.findAll();
    }

    public Task postTask(String title, String comment) {
        final var task = Task.builder().title(title).comment(comment).build();
        return repository.save(task);
    }
}
