package com.dev.fordevs.service;

import com.dev.fordevs.model.Task;
import com.dev.fordevs.model.TaskStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    public void updateStatus(Long taskId, TaskStatus taskStatus) {
    }

    public Long addTask(Task task) {
        return 1L;
    }
}
