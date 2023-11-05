package com.dev.fordevs.repository;

import com.dev.fordevs.model.TaskCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCredentialsRepository extends JpaRepository<TaskCredentials, Long> {
}
