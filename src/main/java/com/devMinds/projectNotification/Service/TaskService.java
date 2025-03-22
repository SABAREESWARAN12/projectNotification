package com.devMinds.projectNotification.Service;

import com.devMinds.projectNotification.Dto.TaskDTO;
import com.devMinds.projectNotification.Entity.Applicant;
import com.devMinds.projectNotification.Entity.Task;
import com.devMinds.projectNotification.Repository.ApplicantRepository;
import com.devMinds.projectNotification.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ApplicantRepository applicantRepository;

    public ResponseEntity<java.lang.String> createTask(Task task, String user) {
        Optional<Task> existingTask = taskRepository.findById(task.getTaskId());
        if (existingTask.isPresent()) {
            throw new RuntimeException("Task Already Present");
        } else {
            taskRepository.save(task);
            Optional<Applicant> applicant = applicantRepository.findById(user);
            applicant.get().getTaskList().add(task);
            applicantRepository.save(applicant.get());

        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }
    public ResponseEntity<java.lang.String> editTask(Task task, String user) {
        Optional<Task> existingTask = taskRepository.findById(task.getTaskId());
        if (existingTask.isEmpty()) {
            throw new RuntimeException("Task not Present");
        } else {
            taskRepository.save(task);
            Optional<Applicant> applicant = applicantRepository.findById(user);
            applicant.get().getTaskList().add(task);
            applicantRepository.save(applicant.get());
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(202));
    }
    public ResponseEntity<java.lang.String> deleteTask(String id, String user) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isEmpty()) {
            throw new RuntimeException("Task not Present");
        } else {
            taskRepository.delete(existingTask.get());
            Optional<Applicant> applicant = applicantRepository.findById(user);
            applicant.get().getTaskList().remove(existingTask);
            applicantRepository.save(applicant.get());
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(202));
    }

    public List<TaskDTO> getTaskDto(String emailId) {
        Optional<Applicant> applicant = applicantRepository.findById(emailId);
        List<TaskDTO> taskDTOList = applicant.get().getTaskList().stream()
                .map(o -> new TaskDTO(o.getTaskId(), o.getTaskSubject(), o.getStatus(), o.getIsEnabledNotification()))
                .collect(Collectors.toList());
        return taskDTOList;
    }
}
