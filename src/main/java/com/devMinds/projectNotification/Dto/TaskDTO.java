package com.devMinds.projectNotification.Dto;

public class TaskDTO {
    private String taskName;
    private String taskSubject;
    private String taskStatus;
    private String isEnabledNotification;

    public TaskDTO() {
    }

    public TaskDTO(String taskName, String taskSubject, String taskStatus, String isEnabledNotification) {
        this.taskName = taskName;
        this.taskSubject = taskSubject;
        this.taskStatus = taskStatus;
        this.isEnabledNotification = isEnabledNotification;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskSubject() {
        return taskSubject;
    }

    public void setTaskSubject(String taskSubject) {
        this.taskSubject = taskSubject;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getIsEnabledNotification() {
        return isEnabledNotification;
    }

    public void setIsEnabledNotification(String isEnabledNotification) {
        this.isEnabledNotification = isEnabledNotification;
    }
}
