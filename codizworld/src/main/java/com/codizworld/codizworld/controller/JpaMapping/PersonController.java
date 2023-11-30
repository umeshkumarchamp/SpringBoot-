package com.codizworld.codizworld.controller.JpaMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codizworld.codizworld.model.springdatajpa.Person;
import com.codizworld.codizworld.service.PersonService;

@RestController
@RequestMapping(value = "api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addNewPerson(@RequestBody Person person) {
        Person p = personService.addPerson(person);
        Map<String,Object> map = new HashMap<String,Object>();
        if (person != null) {
            map.put("message", "Person Add Successfully");
            map.put("data", p);
            map.put("status", true);
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        }else{
            map.put("message", "Something Went Wrong !"); 
            map.put("data", person);
            map.put("status", false);
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Person>> getPersonList() {
        List<Person> p = personService.getPersonList();
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePerson(@RequestParam(name = "personId") Integer id) {
        String res = personService.removePerson(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Map<String,Object>> getPerson(@RequestParam(name = "personId") Integer id) {
        Person person = personService.getPersonById(id);
        Map<String,Object> map = new HashMap<String,Object>();
        if (person != null) {
            map.put("message", "Details Fetched Successfully");
            map.put("data", person);
            map.put("status", true);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.put("message", "Person not found !"); 
            map.put("data", person);
            map.put("status", false);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
