package com.devMinds.projectNotification.Dto;

public class ApplicantDTO {
    private String username;
    private String mailId;
    private long noOfTask;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public long getNoOfTask() {
        return noOfTask;
    }

    public void setNoOfTask(long noOfTask) {
        this.noOfTask = noOfTask;
    }

    public ApplicantDTO(ApplicationDTOBuilder builder) {
        this.username = builder.username;
        this.mailId = builder.mailId;
        this.noOfTask = builder.noOfTask;
    }

    public static class ApplicationDTOBuilder{
        private String username;
        private String mailId;
        private long noOfTask;

        public ApplicationDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public ApplicationDTOBuilder mailId(String mailId) {
            this.mailId = mailId;
            return this;
        }

        public ApplicationDTOBuilder noOfTask(long noOfTask) {
            this.noOfTask = noOfTask;
            return this;
        }

        public ApplicantDTO build() {
            return new ApplicantDTO(this);
        }

    }
}
