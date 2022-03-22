package pers.ananliangliang.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.ananliangliang.todo.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
