package com.dev.fordevs.security.repository;

import com.dev.fordevs.model.Project;
import com.dev.fordevs.model.ProjectCredentials;
import com.dev.fordevs.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    List<User> findAllByAssignedProjects(Set<ProjectCredentials> projectCredentials);
}
