package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserDao {
    void create(User user);
    void delete(User user);
    Optional<User> getById(long id);
    Optional<User> getByUserName(String username);
    void update(String username, User user);
    boolean contains(long id);
    boolean containsByUserName(String username);
    boolean containsByUsernameAndPassword(String username, String password);
}
