package com.springmvc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springmvc.web.model.User;
import com.springmvc.web.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listOfUsers(Model model){
        
        List<User> list = userService.getAllUsers();
        model.addAttribute("users", list);
        System.out.println(list.size());
        return "views/users";
    }

}
