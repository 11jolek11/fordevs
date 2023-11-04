package com.dev.fordevs.security.service.utils;


import com.dev.fordevs.model.Specialization;
import com.dev.fordevs.security.model.Role;

import java.util.Objects;

public class RegisterRequest {
    private String name;
    private String password;
    private String email;
    private Role role;
    private Specialization specialization;

    public RegisterRequest(String name, String password, String email, Role role, Specialization specialization) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterRequest that = (RegisterRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && role == that.role && Objects.equals(specialization, that.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, email, role, specialization);
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", specialization=" + specialization +
                '}';
    }

    public static class RegisterRequestBuilder {
        private String name;
        private String password;
        private String email;
        private Role role;
        private Specialization specialization;

        public RegisterRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RegisterRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public RegisterRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterRequestBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public RegisterRequestBuilder specialization(Specialization specialization) {
            this.specialization = specialization;
            return this;
        }

        public RegisterRequest build() {
            return new RegisterRequest(this.name, this.password, this.email, this.role, this.specialization);
        }

        @Override
        public String toString() {
            return "RegisterRequestBuilder{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", role=" + role +
                    ", specialization=" + specialization +
                    '}';
        }
    }
}