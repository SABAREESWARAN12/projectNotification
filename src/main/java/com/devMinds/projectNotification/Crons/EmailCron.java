package com.devMinds.projectNotification.Crons;

import com.devMinds.projectNotification.Entity.Applicant;
import com.devMinds.projectNotification.Entity.Task;
import com.devMinds.projectNotification.Repository.ApplicantRepository;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Component
public class EmailCron {

    private String username;
    private String password;
    private String adminMail;

    @Autowired
    private ApplicantRepository repository;

    @Scheduled(cron = "0 0 17 * * ?")
    @Async
    public void MailerNotification() throws MessagingException {

        for(Applicant applicant : repository.findAll()) {
            List<Task> notifEnabledTasks =
                    applicant.getTaskList().stream().filter(e -> e.getIsEnabledNotification())
                            .collect(Collectors.toList());
            for(Task task : notifEnabledTasks) {
                String mailMsg = """
                        Hey there you have to take a look on the project
                        """;
                String mailSubject = String.format("%s | %s", task.getTaskId(), task.getTaskSubject());
                String receiver = applicant.getEmailId();
                sendMail(mailMsg, mailSubject, receiver);
            }
        }


    }

    public void sendMail(String msg, String subject, String receiver) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(adminMail));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(receiver));
        message.setSubject(subject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }

}
