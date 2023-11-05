package com.dev.fordevs.service;

import com.dev.fordevs.model.Project;
import com.dev.fordevs.model.ProjectCredentials;
import com.dev.fordevs.model.Task;
import com.dev.fordevs.model.TaskCredentials;
import com.dev.fordevs.repository.ProjectCredentialsRepository;
import com.dev.fordevs.repository.ProjectRepository;
import com.dev.fordevs.repository.TaskCredentialsRepository;
import com.dev.fordevs.repository.TaskRepository;
import com.dev.fordevs.security.model.User;
import com.dev.fordevs.security.repository.UserRepository;
import com.dev.fordevs.service.exception.ItemNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectCredentialsRepository projectCredentialsRepository;
    private final TaskRepository taskRepository;
    private final TaskCredentialsRepository taskCredentialsRepository;

    private final UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository, ProjectCredentialsRepository projectCredentialsRepository, TaskRepository taskRepository, TaskCredentialsRepository taskCredentialsRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.projectCredentialsRepository = projectCredentialsRepository;
        this.taskRepository = taskRepository;
        this.taskCredentialsRepository = taskCredentialsRepository;
        this.userRepository = userRepository;
    }

    public void assignTask(Long projectId, Long taskId) {
        Project project = this.projectRepository.findById(projectId).orElseThrow(() -> new ItemNotFoundException("Project with id: "  + projectId + " not found"));
        Task task = this.taskRepository.findById(taskId).orElseThrow(() -> new ItemNotFoundException("Task with id: "  + taskId + " not found"));
        List<Task> targetTasks = new ArrayList<>(project.getTasks());
        targetTasks.add(task);
        project.setTasks(new HashSet<>(targetTasks));
        this.projectRepository.save(project);
    }

    public List<Project> getProjectsByUserId(Long userId) {
        // Ugly
        List<User> target_user = new ArrayList<>();
        target_user.add(this.userRepository.findById(userId).orElseThrow(() -> new ItemNotFoundException("User with id: "  + userId + " not found")));
        List<ProjectCredentials> projectCredentials_target = this.projectCredentialsRepository.findProjectCredentialsByUsersIn(target_user);
//        return this.projectRepository.findAllByProjectCredentials(projectCredentials_target);
        return this.projectRepository.findAllByProjectCredentialsIn(projectCredentials_target);

    }

    public void addProject(Project project) {
        this.projectRepository.save(project);
    }

    public Project getProjectById(Long projectId) {
        return this.projectRepository.findById(projectId).orElseThrow(() -> new ItemNotFoundException("Project with id: "  + projectId + " not found"));
    }

    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    public List<Project> getProjects() {
        Pageable paging = PageRequest.of(0, 20);
        return this.projectRepository.findAll(paging).getContent();
    }
    public List<Project> getProjects(Integer page) {
        Pageable paging = PageRequest.of(page, 20);
        return this.projectRepository.findAll(paging).getContent();
    }
}
