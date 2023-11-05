package com.dev.fordevs.repository;

import com.dev.fordevs.model.Project;
import com.dev.fordevs.model.ProjectCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
//    Optional<Project> findProjectByProjectCredentials(ProjectCredentials projectCredentials);
//    List<Project> findAllByProjectCredentials(ProjectCredentials projectCredentials);
    List<Project> findAllByProjectCredentialsIn(List<ProjectCredentials> projectCredentials);
}
