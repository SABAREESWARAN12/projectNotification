package com.devMinds.projectNotification.Controller;

import com.devMinds.projectNotification.Entity.Applicant;
import com.devMinds.projectNotification.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;
    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody Applicant applicant) {
        return applicantService.createApplicant(applicant);
    }
}
