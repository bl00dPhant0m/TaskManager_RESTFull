package org.example.taskmanager_restfull.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.taskmanager_restfull.model.enums.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private LocalDateTime deadline;


    public void setTitle(String title) {
        updatedAt = LocalDateTime.now();
        this.title = title;
    }

    public void setDescription(String description) {
        updatedAt = LocalDateTime.now();
        this.description = description;
    }

    public void setStatus(Status status) {
        updatedAt = LocalDateTime.now();
        this.status = status;
    }

    public void setDeadlineAt(LocalDateTime deadlineAt) {
        updatedAt = LocalDateTime.now();
        this.deadline = deadlineAt;
    }
}
