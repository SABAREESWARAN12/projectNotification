package com.devMinds.projectNotification.Repository;

import com.devMinds.projectNotification.Entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, java.lang.String> {
}
