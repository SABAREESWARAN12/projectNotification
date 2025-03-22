package com.devMinds.projectNotification.Controller;

import com.devMinds.projectNotification.Entity.Task;
import com.devMinds.projectNotification.Repository.TaskRepository;
import com.devMinds.projectNotification.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping("createTask")
    public ResponseEntity createTask(Principal principal,  @RequestBody Task task) {
        return service.createTask(task, principal.getName());
    }
}
