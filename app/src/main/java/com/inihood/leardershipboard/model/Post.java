package com.inihood.leardershipboard.model;

public class Post {
    String firstName;
    String lastName;
    String email;
    String project;

    public Post() {
    }

    public Post(String firstName, String lastName, String email, String project) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.project = project;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
