package com.devMinds.projectNotification.Service;

import com.devMinds.projectNotification.Dto.ApplicantDTO;
import com.devMinds.projectNotification.Entity.Applicant;
import com.devMinds.projectNotification.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> createApplicant(Applicant applicant) {
        Optional<Applicant> existingApplicant = repository.findById(applicant.getEmailId());
        if (existingApplicant.isPresent()) {
            throw new RuntimeException("Applicant already present");
        }
        applicant.setPassword(passwordEncoder.encode(applicant.getPassword()));
        repository.save(applicant);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    public ResponseEntity<String> modifyApplicant(Applicant applicant) {
        Optional<Applicant> existingApplicant = repository.findById(applicant.getEmailId());
        if (existingApplicant.isEmpty()) {
            throw new RuntimeException("Something Went wrong");
        }
        applicant.setPassword(passwordEncoder.encode(applicant.getPassword()));
        repository.save(applicant);
        return new ResponseEntity<>(HttpStatusCode.valueOf(202));
    }

    public ResponseEntity<String> deleteApplicant(String emailId) {
        Optional<Applicant> existingApplicant = repository.findById(emailId);
        if (existingApplicant.isEmpty()) {
            throw new RuntimeException("Something Went wrong");
        }
        repository.delete(existingApplicant.get());
        return new ResponseEntity<>(HttpStatusCode.valueOf(202));
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
