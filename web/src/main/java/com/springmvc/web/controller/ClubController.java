package com.springmvc.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.web.dto.ClubDto;
import com.springmvc.web.model.Club;
import com.springmvc.web.service.ClubService;


@Controller
public class ClubController {
    
    @Autowired
    private ClubService clubService;
    
    @GetMapping({"/", "/index"})
    public String index(Model model){
        Club club = new Club(); 
        club.setId(78L);
        club.setContent("This is Bahubali first series.");
        club.setPhotoUrl("www.codizworld.com/photos/");
        club.setTitle("Bahubali");
        club.setCreatedOn(LocalDateTime.now());
        club.setUpdatedOn(LocalDateTime.now());
        model.addAttribute("club", club);
        return "views/index";
    }

    @GetMapping("/clubs")
    public String listOfClub(Model model){
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("id", 10005);
        return "views/contact";

    }

    @ResponseBody
    @GetMapping("/emp/{id}")
    public String emp(@PathVariable("id") String id) {
        return "Your Employee Id : " + id;
    }

    @ResponseBody
    @GetMapping("/emp")
    public String emp2(@PathVariable("id") String id) {
        return "Your Employee Id : " + id;
    }

    

}
