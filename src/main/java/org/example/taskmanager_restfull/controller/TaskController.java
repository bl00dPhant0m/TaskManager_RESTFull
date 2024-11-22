package org.example.taskmanager_restfull.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.taskmanager_restfull.model.entity.Task;
import org.example.taskmanager_restfull.model.enums.Status;
import org.example.taskmanager_restfull.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    @PostMapping
    public ResponseEntity<List<Task>> addTasks(@RequestBody List<Task> tasks) {

        return ResponseEntity.ok(taskService.addTasks(tasks));
    }

    @GetMapping()
    public ResponseEntity<List<Task>> getTasksWithStatus(@RequestParam(required = false) String status) {
        if (status == null || status.isEmpty()) {
            return ResponseEntity.ok(taskService.findAllTasks());
        }

        Status statusEnum = Status.NEW;
                try{
                    statusEnum = Status.valueOf(status);
                } catch (IllegalArgumentException e) {
                    log.error("Не правильно указан статус: " + status);
                    return ResponseEntity.badRequest().build();
                }

        return ResponseEntity.ok(taskService.findAllTasksByStatus(statusEnum));

    }



    @DeleteMapping
    public ResponseEntity<Void> deleteAllTasks() {
        taskService.deleteAllTasks();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }
}
