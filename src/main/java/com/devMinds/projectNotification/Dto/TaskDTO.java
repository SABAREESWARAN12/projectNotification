package com.devMinds.projectNotification.Dto;

public class TaskDTO {
    private String taskName;
    private String taskSubject;
    private String taskStatus;
    private boolean isEnabledNotification;

    public TaskDTO() {
    }

    public TaskDTO(String taskName, String taskSubject, String taskStatus, boolean isEnabledNotification) {
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

    public boolean getIsEnabledNotification() {
        return isEnabledNotification;
    }

    public void setIsEnabledNotification(boolean isEnabledNotification) {
        this.isEnabledNotification = isEnabledNotification;
    }
}
