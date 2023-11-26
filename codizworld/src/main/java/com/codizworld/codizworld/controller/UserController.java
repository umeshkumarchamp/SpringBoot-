package com.codizworld.codizworld.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codizworld.codizworld.model.User;
import com.codizworld.codizworld.service.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private UserService userService; 

    public UserController(UserService userService) {
        this.userService = userService;
    }
    

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@Validated @RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("User Added Successfully!", HttpStatus.CREATED);
    }

    @GetMapping("retrieve-all")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/get-by-id")
    public ResponseEntity<User> getUserById(@RequestParam(name = "id", required = true) Long id){
        User user = userService.getUserById(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/get-by-username")
    public ResponseEntity<User> getUserByUsername(@RequestParam(name="username") String username){
        User user = userService.getUserByUserName(username);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable Long id){
        boolean res = userService.updateUser(user, id);
        if(res){
            return new ResponseEntity<>("User updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Something Went Wrong !",HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserById(@RequestParam Long userId){
        String res = userService.deleteUser(userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
