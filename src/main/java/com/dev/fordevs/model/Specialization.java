package com.dev.fordevs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
public class Specialization {
    @Id
    @SequenceGenerator(name = "spec_id_generator", sequenceName = "spec_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spec_id_generator")
    private Long id;
    @NotBlank
    private String name;

    public Specialization() {
    }

    public Specialization(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
