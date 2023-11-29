package com.codizworld.codizworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codizworld.codizworld.model.Person;
import com.codizworld.codizworld.service.PersonService;

@RestController
@RequestMapping(value = "api/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<Person> addNewPerson(@RequestBody Person person) {
        Person p = personService.addPerson(person);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
}
