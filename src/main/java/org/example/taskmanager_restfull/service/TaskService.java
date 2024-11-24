package org.example.taskmanager_restfull.service;

import org.example.taskmanager_restfull.model.entity.Task;
import org.example.taskmanager_restfull.model.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    List<Task> addTasks(List<Task> tasks);
    List<Task> findAllTasksByStatus(Status status);
    List<Task> findAllTasks();
    Task findTaskById(long id);
    void deleteTaskById(long id);
    void deleteAllTasks();
    Page<Task> findAllTasks(Pageable pageable);
}
