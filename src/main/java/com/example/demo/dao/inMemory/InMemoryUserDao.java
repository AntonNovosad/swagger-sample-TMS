package com.example.demo.dao.inMemory;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryUserDao implements UserDao {
    private static List<User> userList = new ArrayList<>();

    @Override
    public void create(User user) {
        userList.add(user);
    }

    @Override
    public void delete(User user) {
        userList.remove(user);
    }

    @Override
    public Optional<User> getById(long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getByUserName(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(String username, User user) {
        for (User us : userList) {
            if (us.getUsername().equals(user.getUsername())) {
                user.setUsername(username);
            }
        }
    }

    @Override
    public boolean contains(long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByUserName(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByUsernameAndPassword(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
