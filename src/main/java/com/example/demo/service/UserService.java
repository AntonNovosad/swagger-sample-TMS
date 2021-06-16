package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean create(User user) {
        if (checkSave(user.getId(), user.getUsername())) {
            userDao.create(user);
            return true;
        }
        return false;
    }

    public boolean delete(String username) {
        if (userDao.containsByUserName(username)) {
            User user = userDao.getByUserName(username).get();
            userDao.delete(user);
            return true;
        }
        return false;
    }

    public boolean login(String username, String password) {
        if (userDao.containsByUsernameAndPassword(username, password)) {
            return true;
        }
        return false;
    }

    public void update(String username, User user) {
        if (checkSave(user.getId(), user.getUsername())) {
            userDao.update(username, user);
        }
    }

    public User getByUserName(String username) {
        Optional<User> user = userDao.getByUserName(username);
        return user.orElse(null);
    }

    private boolean checkSave(long id, String username) {
        if (userDao.contains(id)) {
            return false;
        }
        return !userDao.containsByUserName(username);
    }
}
