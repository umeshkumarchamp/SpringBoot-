package com.springmvc.web.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.web.model.User;
import com.springmvc.web.repository.UserRepository;
import com.springmvc.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public User addUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addUser'");
    }
    
}
