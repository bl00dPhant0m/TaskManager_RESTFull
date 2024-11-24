package org.example.taskmanager_restfull.service;

import lombok.RequiredArgsConstructor;
import org.example.taskmanager_restfull.exception.TaskNotFoundException;
import org.example.taskmanager_restfull.model.entity.Task;
import org.example.taskmanager_restfull.model.enums.Status;
import org.example.taskmanager_restfull.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task findTaskById(long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Задача с id " + id + " не найдена"));
    }

    @Override
    public void deleteTaskById(long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Задача с id " + id + " не найдена");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    @Override
    public List<Task> addTasks(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

    @Override
    public List<Task> findAllTasksByStatus(Status status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Page<Task> findAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }
}
