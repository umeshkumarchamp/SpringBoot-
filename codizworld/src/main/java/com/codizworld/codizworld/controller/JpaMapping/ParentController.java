package com.codizworld.codizworld.controller.JpaMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codizworld.codizworld.model.springdatajpa.Parent;
import com.codizworld.codizworld.service.ParentService;

@RestController
@RequestMapping(value = "/api/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    Map<String, Object> res = new HashMap<>();

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addParent(@RequestBody Parent parent) {

        Parent p = parentService.addParent(parent);
        if (p != null) {
            res.put("message", "Parent Added Successfully.");
            res.put("status", true);
            res.put("data", p);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        res.put("message", "Something went wrong !.");
        res.put("status", false);
        res.put("data", p);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getPersonList() {
        List<Parent> list = parentService.getParentList();
        if (list != null) {
            res.put("message", "Details Fetched Successfully.");
            res.put("status", true);
            res.put("data", list);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        res.put("message", "Something Went Wrong !.");
        res.put("status", false);
        res.put("data", list);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
