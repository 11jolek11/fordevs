package com.dev.fordevs.security.model;

import com.dev.fordevs.model.Specialization;
import com.dev.fordevs.model.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "_user")
public class User implements UserDetails {
    // TODO: How to handle history of Tasks?
//    User is a DEVELOPER
    @Id
    @SequenceGenerator(name = "_user_id_seq_generator", sequenceName = "_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_user_id_seq_generator")
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String name;

    @Email
    @JsonIgnore
    private String email;

    @NotEmpty
    @JsonIgnore
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks;

    // TODO: Should be relat Project <-> User be bidirectional?
//    @ManyToMany(mappedBy = )
//    private Set<Project> projects;

    @ManyToOne(optional = false)
    private Specialization specialization;

    public User() {
    }

    public User(String name, String email, String password, Role role, Specialization specialization) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

//    public Set<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(Set<Project> projects) {
//        this.projects = projects;
//    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && role == user.role && Objects.equals(tasks, user.tasks) /*&& Objects.equals(projects, user.projects)*/ && Objects.equals(specialization, user.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, role, tasks, /*projects,*/ specialization);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", tasks=" + tasks +
                /*", projects=" + projects + */
                ", specialization=" + specialization +
                '}';
    }
}
