package org.example.taskmanager_restfull.repository;

import org.example.taskmanager_restfull.model.entity.Task;
import org.example.taskmanager_restfull.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(Status status);
}
