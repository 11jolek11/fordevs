package com.dev.fordevs.repository;

import com.dev.fordevs.model.ProjectCredentials;
import com.dev.fordevs.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProjectCredentialsRepository extends JpaRepository<ProjectCredentials, Long> {
    List<ProjectCredentials> findProjectCredentialsByUsers(Set<User> users);
}
