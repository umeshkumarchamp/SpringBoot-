package com.codizworld.codizworld.service_implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.codizworld.codizworld.model.User;
import com.codizworld.codizworld.repository.UserRepository;
import com.codizworld.codizworld.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    /**
     * Parametrized Constructor
     * 
     * @param userRepo
     */
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Add a New User
     */
    @Override
    public boolean addUser(User user) {
        try {
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    /**
     * Get User By Id.....
     * 
     * @param userId
     * @return
     */
    public User getUserById(Long userId) {
        return userRepo.getUserById(userId);
    }

    /**
     * Get User by username
     */
    @Override
    public User getUserByUserName(String userName) {
        return userRepo.findByUsername(userName);
    }

    /**
     * Update User BY Id
     */
    @Override
    public boolean updateUser(User updatedUser, Long userId) {
        if (updatedUser == null) {
            return false;
        }
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setContact(updatedUser.getContact());
            existingUser.setDob(updatedUser.getDob());
            existingUser.setAddress(updatedUser.getAddress());
            try {
                userRepo.save(existingUser);
                return true;
            } catch (DataAccessException ex) {
                return false;
            }
        }
        return false;
    }

    /**
     * Delete User BY Id
     */
    @Override
    public String deleteUser(Long userId) {
        if (userRepo.existsById(userId)) {
            userRepo.deleteById(userId);
            return "User Deleted Successfully";
        } else {
            return "User Not Found !";
        }
    }

}
