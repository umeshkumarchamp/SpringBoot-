package com.springmvc.web.service;

import java.util.List;

import com.springmvc.web.model.User;

public interface UserService {

    public List<User> getAllUsers();

    public User addUser(User user);
    
}
