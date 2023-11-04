package com.dev.fordevs.security.service.utils;


import java.util.Objects;

public class RegisterRequest {
    private String name;
    private String password;
    private String email;

    public RegisterRequest(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterRequest that = (RegisterRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, email);
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class RegisterRequestBuilder {
        private String name;
        private String password;
        private String email;

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

        public RegisterRequest build() {
            return new RegisterRequest(this.name, this.password, this.email);
        }

        @Override
        public String toString() {
            return "RegisterRequestBuilder{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}