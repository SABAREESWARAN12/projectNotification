package com.devMinds.projectNotification.Entity;


import com.devMinds.projectNotification.Dto.ApplicantDTO;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
public class Applicant {
    @MongoId
    private String emailId;
    private String name;
    private List<Task> taskList;

    public Applicant() {
    }

    public Applicant(Builder builder) {
        this.emailId = builder.emailId;
        this.name = builder.name;
        this.taskList = builder.taskList;
    }

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

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public static class Builder {
        private String emailId;
        private String name;
        private List<Task> taskList;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        public Builder setTaskList(List<Task> taskList) {
            this.taskList = taskList;
            return this;
        }

        public Applicant build() {
            return new Applicant(this);
        }
    }
}
