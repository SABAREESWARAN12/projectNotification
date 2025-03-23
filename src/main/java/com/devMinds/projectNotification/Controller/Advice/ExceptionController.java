package com.devMinds.projectNotification.Controller.Advice;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RuntimeException.class)
    public String advice(Exception ex, ModelMap modelMap) {
        modelMap.addAttribute("error", ex);
        return "error";
    }
}
