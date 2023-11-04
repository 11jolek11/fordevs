package com.dev.fordevs.model;

import com.dev.fordevs.security.model.User;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class ProjectCredentials {
    @Id
    @SequenceGenerator(name = "_order_id_gen", sequenceName = "_order_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_order_id_gen")
    private Long id;

    @OneToOne(mappedBy = "projectCredentials")
    private Project project;

//    @ManyToMany
//    @JoinTable(name = "project_cred_user",
//            joinColumns = @JoinColumn(name = "project_cred_id"),
//            inverseJoinColumns = @JoinColumn(name = "_user_id"))
//    private Set<User> users;

    @ManyToMany(mappedBy = "assignedProjects")
    private Set<User> users;

    public ProjectCredentials() {
    }

    public ProjectCredentials(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectCredentials that = (ProjectCredentials) o;
        return Objects.equals(id, that.id) && Objects.equals(project, that.project) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, project, users);
    }

    @Override
    public String toString() {
        return "ProjectCredentials{" +
                "id=" + id +
                ", project=" + project +
                ", users=" + users +
                '}';
    }
}
