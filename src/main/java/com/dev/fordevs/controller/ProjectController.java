package com.dev.fordevs.controller;

import com.dev.fordevs.model.Project;
import com.dev.fordevs.model.Task;
import com.dev.fordevs.model.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/project/")
public class ProjectController {
    private final ProjectService projectService;
    private final TaskService taskService;

    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public Set<Project> getAllProjects() {
//        TODO: Add pagination?
        return this.projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public Optional<Project> getProjectById(@PathVariable("projectId") Integer id) {
        return this.projectService.getProjectById(id);
    }

    @PostMapping("/")
    public void addProject(@Valid @RequestBody Project project) {
        this.projectService.addProject(project);
    }

    @GetMapping("/user")
    // using RequestParam because
    // https://github.com/Solvro/rekrutacja.zima.2023/blob/master/backend.md#wy%C5%9Bwietlenie-projekt%C3%B3w-u%C5%BCytkownika
    // there is no place for PathVariable in specification
    public List<Project> projectsOfUser(@RequestParam Long userId) {
        // TODO: think about it
        return this.projectService.getProjectsByUserId(userId);
    }

    @PostMapping("/{projectId}/task")
    public void addTaskToProject(@PathVariable("projectId") Long projectId, @Valid @RequestBody Task task) {
        Long taskId = this.taskService.addTask(task); // TODO: Return task id
        this.projectService.assignTask(projectId, taskId);
    }

    @PutMapping("/{projectId}/task/{taskId}")
    // Q: What is the purpose of projectId in specification? taskId is already unique
    // https://github.com/Solvro/rekrutacja.zima.2023/blob/master/backend.md#edycja-statusu-taska
    // Leaving projectId just to cover my ass and meet req in spec.
    public void updateTaskStatus(@PathVariable("projectId") Long projectId, @PathVariable Long taskId, @RequestParam TaskStatus taskStatus) {
        this.taskService.updateStatus(taskId, taskStatus);
    }

    @PostMapping("/{projectId}/assignment")
    public void createAssigmentInProject(@PathVariable("projectId") Long projectId) {
    // TODO: Implement
        System.out.println("Hello World!");
    }

    @PutMapping("/{projectId}/assignment/{assigmentId}")
    // Map<String, Boolean>
    public void assignmentAccept(@PathVariable("projectId") Long projectId, @PathVariable("assigmentId") Long assigmentId) {
        // TODO: Implement
    }
}
