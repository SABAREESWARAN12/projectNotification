package com.devMinds.projectNotification.Service;

import com.devMinds.projectNotification.Dto.ApplicantDTO;
import com.devMinds.projectNotification.Entity.Applicant;
import com.devMinds.projectNotification.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository repository;

    public void createApplicant(OAuth2AuthenticationToken principle) {
        Optional<Applicant> existingApplicant = repository.findById(principle.getPrincipal().getAttribute("email"));
        if (existingApplicant.isEmpty()) {
            repository.save(new Applicant.Builder().setName(principle.getPrincipal().getAttribute("name"))
                    .setEmailId(principle.getPrincipal().getAttribute("email"))
                    .setTaskList(List.of()).build());
        }
    }

    public ApplicantDTO getApplicantDTO (String emailId) {
        Optional<Applicant> existingApplicant = repository.findById(emailId);
        if (existingApplicant.isEmpty()) {
            throw new RuntimeException("EmailId is not valid");
        }
        return new ApplicantDTO.ApplicationDTOBuilder()
                .username(existingApplicant.get().getName())
                .mailId(existingApplicant.get().getEmailId())
                .noOfTask(existingApplicant.get().getTaskList().size())
                .build();
    }
}
