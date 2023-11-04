package com.dev.fordevs.repository;

import com.dev.fordevs.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
