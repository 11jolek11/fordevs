package com.dev.fordevs.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Task {
    @Id
    @SequenceGenerator(name = "task_id_generator", sequenceName = "task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_generator")
    private Long id;

    @CreatedDate
    private LocalDate creationDate;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;

    private String title;
// TODO: Reconsider using BLOB
//    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    @Column(columnDefinition = "BLOB")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "_project_id", referencedColumnName = "id")
    private Project project;

    public Task() {
    }

    public Task(String title, String description, Project project, TaskStatus taskStatus) {
        this.title = title;
        this.description = description;
        this.project = project;
        this.taskStatus = taskStatus;
    }

    public Task(String title, String description, Project project) {
        this.title = title;
        this.description = description;
        this.project = project;
        this.taskStatus = TaskStatus.UNASSIGNED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(creationDate, task.creationDate) && taskStatus == task.taskStatus && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(user, task.user) && Objects.equals(project, task.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, taskStatus, title, description, user, project);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", taskStatus=" + taskStatus +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", project=" + project +
                '}';
    }
}
