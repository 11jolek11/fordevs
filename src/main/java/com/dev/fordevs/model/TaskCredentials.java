package com.dev.fordevs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class TaskCredentials {
    @Id
    @SequenceGenerator(name = "_task_cred_id_gen", sequenceName = "_order_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_task_cred_id_gen")
    private Long id;

    @OneToOne(mappedBy = "taskCredentials")
    private Task task;

    @OneToOne(optional = false)
    @JoinColumn(name = "specialization", referencedColumnName = "id")
    private Specialization specialization;

    @Min(0)
    @NotNull
    private int estimation;

    public TaskCredentials() {
    }

    public TaskCredentials(Task task, Specialization specialization, int estimation) {
        this.task = task;
        this.specialization = specialization;
        this.estimation = estimation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskCredentials that = (TaskCredentials) o;
        return estimation == that.estimation && Objects.equals(id, that.id) && Objects.equals(task, that.task) && Objects.equals(specialization, that.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, specialization, estimation);
    }

    @Override
    public String toString() {
        return "TaskCredentials{" +
                "id=" + id +
                ", task=" + task +
                ", specialization=" + specialization +
                ", estimation=" + estimation +
                '}';
    }
}
