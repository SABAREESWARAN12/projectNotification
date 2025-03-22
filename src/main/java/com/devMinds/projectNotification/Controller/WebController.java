package com.devMinds.projectNotification.Controller;

import com.devMinds.projectNotification.Dto.ApplicantDTO;
import com.devMinds.projectNotification.Dto.TaskDTO;
import com.devMinds.projectNotification.Service.ApplicantService;
import com.devMinds.projectNotification.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
@SessionAttributes("applicant")
public class WebController {
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private TaskService taskService;

    @GetMapping("dashboard")
    public String dashboard(OAuth2AuthenticationToken principal, ModelMap modelMap) {
        if (Objects.isNull(principal)) {
            modelMap.addAttribute("applicant", new ApplicantDTO.ApplicationDTOBuilder().username("User").build());
            return "dashboard";
        }
        applicantService.createApplicant(principal);
        ApplicantDTO applicantDTO =
                applicantService.getApplicantDTO(principal.getPrincipal().getAttributes().get("email").toString());
        List<TaskDTO> taskDTOList = taskService.getTaskDto(principal.getPrincipal().getAttributes().get("email").toString());
        modelMap.addAttribute("applicant", applicantDTO);
        modelMap.addAttribute("task", taskDTOList);
        return "dashboard";
    }

}
