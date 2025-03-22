package com.devMinds.projectNotification.Controller;

import com.devMinds.projectNotification.Dto.ApplicantDTO;
import com.devMinds.projectNotification.Dto.TaskDTO;
import com.devMinds.projectNotification.Service.ApplicantService;
import com.devMinds.projectNotification.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private TaskService taskService;

    @GetMapping("dashboard")
    public String dashboard(Authentication principal, ModelMap modelMap) {
        ApplicantDTO applicantDTO = applicantService.getApplicantDTO(principal.getName());
        List<TaskDTO> taskDTOList = taskService.getTaskDto(principal.getName());
        modelMap.addAttribute("applicant", applicantDTO);
        modelMap.addAttribute("task", taskDTOList);
        return "dashboard";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
