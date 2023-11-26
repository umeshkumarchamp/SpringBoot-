package com.codizworld.codizworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codizworld.codizworld.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query(value="SELECT * FROM users", nativeQuery = true)
    public List<User> getAllUsers();

    /**
     * Find User BY UserId
     * @param id
     * @return
     */
    @Query(value="SELECT * FROM users WHERE id = :id", nativeQuery = true)
    public User getUserById(@Param("id") Long id);

    /**
     * Find User BY Username
     * @param username
     * @return
     */
    @Query(value="SELECT * FROM users WHERE username = :username", nativeQuery=true)
    public User findByUsername(String username);

    // @Query(value="DELETE FROM users WHERE id = :id", nativeQuery=true)
    // public void deleteUser(Long id);

}
