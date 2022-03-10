package pers.ananliangliang.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.ananliangliang.todo.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
