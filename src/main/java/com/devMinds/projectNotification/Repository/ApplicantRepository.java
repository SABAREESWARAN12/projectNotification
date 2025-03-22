package com.devMinds.projectNotification.Repository;

import com.devMinds.projectNotification.Entity.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ApplicantRepository extends MongoRepository<Applicant, String> {
}
