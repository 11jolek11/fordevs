package com.dev.fordevs.model;

import com.dev.fordevs.security.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;
import java.util.Set;

@Entity
public class Project {
    @Id
    @SequenceGenerator(name = "_order_id_gen", sequenceName = "_order_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_order_id_gen")
    private Long id;

    @NotEmpty
    private String title;
    private String description;

    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Task> tasks;

    @OneToOne(optional = false)
    @JoinColumn(name = "maintainer", referencedColumnName = "id")
    private User maintainer; // maintainer != creator

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_creditionals", referencedColumnName = "id")
    private ProjectCredentials projectCredentials;

//    @ManyToMany
//    @JoinTable(name = "project_user",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "_user_id"))
//    private Set<User> users;

    public Project() {
    }

    public Project(String title, String description, User maintainer) {
        this.title = title;
        this.description = description;
        this.maintainer = maintainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public User getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(User maintainer) {
        this.maintainer = maintainer;
    }

    public ProjectCredentials getProjectCredentials() {
        return projectCredentials;
    }

    public void setProjectCredentials(ProjectCredentials projectCredentials) {
        this.projectCredentials = projectCredentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(title, project.title) && Objects.equals(description, project.description) && Objects.equals(tasks, project.tasks) && Objects.equals(maintainer, project.maintainer) && Objects.equals(projectCredentials, project.projectCredentials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, tasks, maintainer, projectCredentials);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", maintainer=" + maintainer +
                ", projectCredentials=" + projectCredentials +
                '}';
    }
}
