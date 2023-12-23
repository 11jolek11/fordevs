package com.dev.fordevs.service;

import com.dev.fordevs.model.Task;
import com.dev.fordevs.model.TaskStatus;
import com.dev.fordevs.repository.TaskCredentialsRepository;
import com.dev.fordevs.repository.TaskRepository;
import com.dev.fordevs.service.exception.ItemNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskCredentialsRepository taskCredentialsRepository;

    public TaskService(TaskRepository taskRepository, TaskCredentialsRepository taskCredentialsRepository) {
        this.taskRepository = taskRepository;
        this.taskCredentialsRepository = taskCredentialsRepository;
    }

    public void updateStatus(Long taskId, TaskStatus taskStatus) {
        Task task = this.taskRepository.findById(taskId).orElseThrow(() -> new ItemNotFoundException("Task with id: "  + taskId + " not found"));
        task.setTaskStatus(taskStatus);
        this.taskRepository.save(task);
    }

    public Long createTask(Task task) {
//        task.getTaskCredentials().getEstimation()
        return this.taskRepository.save(task).getId();
    }
}
