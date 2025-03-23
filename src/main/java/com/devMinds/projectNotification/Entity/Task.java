package com.devMinds.projectNotification.Entity;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

public class Task {

    @MongoId
    private String taskId;
    private String taskSubject;
    private String taskDesc;
    private String status;
    private boolean isEnabledNotification;

    public Task() {
    }

    public Task(String taskId, String taskSubject, String taskDesc, String status, boolean isEnabledNotification) {
        this.taskId = taskId;
        this.taskSubject = taskSubject;
        this.taskDesc = taskDesc;
        this.status = status;
        this.isEnabledNotification = isEnabledNotification;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskSubject() {
        return taskSubject;
    }

    public void setTaskSubject(String taskSubject) {
        this.taskSubject = taskSubject;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getIsEnabledNotification() {
        return isEnabledNotification;
    }

    public void setIsEnabledNotification(boolean isEnabledNotification) {
        this.isEnabledNotification = isEnabledNotification;
    }
}
