package com.devMinds.projectNotification.Controller;

import com.devMinds.projectNotification.Dto.TaskDTO;
import com.devMinds.projectNotification.Entity.Task;
import com.devMinds.projectNotification.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Task/v1")
@SessionAttributes("applicant")
public class TaskController {
    @Autowired
    private TaskService service;

    @RequestMapping("createTask")
    public String taskTemplate(ModelMap modelMap) {
        modelMap.addAttribute("task", new Task());
        modelMap.addAttribute("action", "/Task/v1/add");
        return "TASK/taskCreation";
    }

    @RequestMapping("editTask")
    public String taskEditTemplate(OAuth2AuthenticationToken token, ModelMap modelMap,
                                   @RequestParam String id) {
        modelMap.addAttribute("task", service.getTaskById(
                id, token.getPrincipal().getAttribute("email")));
        modelMap.addAttribute("action", "/Task/v1/edit");
        return "TASK/taskCreation";
    }

    @RequestMapping("add")
    public String addTask(OAuth2AuthenticationToken token, @ModelAttribute Task task, ModelMap modelMap) {
        service.modifyTask(task, token.getPrincipal().getAttribute("email"));
        List<TaskDTO> taskDTOList = service.getTaskDto(token.getPrincipal().getAttributes().get("email").toString());
        modelMap.addAttribute("task", taskDTOList);
        return "redirect:/dashboard";
    }

    @GetMapping("details")
    @ResponseBody
    public ResponseEntity<Task> getTaskDetails(OAuth2AuthenticationToken token, @RequestParam String id, ModelMap modelMap) {
        Task task = service.getTaskById(
                id, token.getPrincipal().getAttribute("email"));
        return ResponseEntity.ok(task);
    }

    @GetMapping("remove")
    public String deleteTask(OAuth2AuthenticationToken token,
                                     @RequestParam String id, ModelMap modelMap) {
        service.deleteTask(id, token.getPrincipal().getAttribute("email"));
        List<TaskDTO> taskDTOList = service.getTaskDto(token.getPrincipal().getAttributes().get("email").toString());
        modelMap.addAttribute("task", taskDTOList);
        return "redirect:/dashboard";
    }
}
