package com.dev.fordevs.repository;

import com.dev.fordevs.model.Project;
import com.dev.fordevs.model.Specialization;
import com.dev.fordevs.model.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TaskRepository extends JpaRepository<Task, Long> {
//    public Set<Task> findTasksByEstimation(int estimation);
//    public Set<Task> findTasksBySpecialization(Specialization specialization);

    public List<Task> findAllByProject(Project project, Pageable pageable);
    public List<Task> countAllByProject(Project project, Pageable pageable);
}
