package com.dev.fordevs.service;

import com.dev.fordevs.model.Project;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {
    public void assignTask(Long projectId, Long taskId) {
    }

    public List<Project> getProjectsByUserId(Long userId) {
        return new ArrayList<>();
    }

    public void addProject(Project project) {
    }

    public Optional<Project> getProjectById(Integer id) {
        return Optional.empty();
    }

    public Set<Project> getAllProjects() {
        return Collections.emptySet();
    }
}
