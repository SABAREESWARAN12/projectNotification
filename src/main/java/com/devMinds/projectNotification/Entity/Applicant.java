package com.devMinds.projectNotification.Entity;


import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
public class Applicant {
    @MongoId
    private String emailId;
    private String name;
    private String password;
    private List<Task> taskList;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
