package com.codizworld.codizworld.service;

import java.util.List;
import com.codizworld.codizworld.model.User;

public interface UserService {
    public boolean addUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User getUserByUserName(String userName);
    public boolean updateUser(User user, Long userId);
    public String deleteUser(Long userId);
}
