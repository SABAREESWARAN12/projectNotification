package com.devMinds.projectNotification.Service;

import com.devMinds.projectNotification.Dto.TaskDTO;
import com.devMinds.projectNotification.Entity.Applicant;
import com.devMinds.projectNotification.Entity.Task;
import com.devMinds.projectNotification.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private ApplicantRepository applicantRepository;


    public void modifyTask(Task task, String user) {
        Optional<Applicant> applicant = applicantRepository.findById(user);
        List<Task> existingTaskList = applicant.get().getTaskList();
        List<Task> exitingTask =
                existingTaskList.stream().filter(r -> r.getTaskId().equals(task.getTaskId()))
                        .collect(Collectors.toList());
        if (exitingTask.isEmpty()) {
            existingTaskList.add(task);
            applicantRepository.save(applicant.get());
        } else {
            existingTaskList.remove(exitingTask.get(0));
            existingTaskList.add(task);
            applicantRepository.save(applicant.get());
        }
    }



    public Task getTaskById(String id, String user) {
        Optional<Applicant> applicant = applicantRepository.findById(user);
        List<Task> existingTaskList = applicant.get().getTaskList();
        existingTaskList.stream().filter(r -> r.getTaskId().equals(id));
        return !existingTaskList.isEmpty() ? existingTaskList.get(0) : null;
    }

    public void deleteTask(String id, String user) {
        Optional<Applicant> applicant = applicantRepository.findById(user);
        List<Task> existingTaskList = applicant.get().getTaskList();
        existingTaskList.stream().filter(r -> r.getTaskId().equals(id));
        if (existingTaskList.isEmpty()) {
            throw new RuntimeException("Task not Present");
        } else {
            applicant.get().getTaskList().remove(existingTaskList.get(0));
            applicantRepository.save(applicant.get());
        }
    }

    public List<TaskDTO> getTaskDto(String emailId) {
        Optional<Applicant> applicant = applicantRepository.findById(emailId);
        List<TaskDTO> taskDTOList = applicant.get().getTaskList().stream()
                .map(o -> new TaskDTO(o.getTaskId(), o.getTaskSubject(), o.getStatus(), o.getIsEnabledNotification()))
                .collect(Collectors.toList());
        return taskDTOList;
    }
}
