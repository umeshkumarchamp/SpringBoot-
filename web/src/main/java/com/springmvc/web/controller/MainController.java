package com.springmvc.web.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("name", "Umesh Kumar Mahto");
        model.addAttribute("date", LocalDateTime.now());
        return "views/about";
    }
}
