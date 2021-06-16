package com.example.demo.controller;

import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/")
    public ResponseEntity<User> save(@RequestBody User user) {
        if (userService.create(user)) {
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Token> login(String username, String password) {
        if (userService.login(username, password)) {
            Token token = tokenService.generate(username);
            return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("X-Token") String tokenId) {
        if (tokenService.delete(tokenId)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{username}")
    public void update(@PathVariable String username, @RequestBody User user) {
        userService.update(username, user);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable String username) {
        if (userService.delete(username)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getByUserName(@PathVariable String username) {
        User user = userService.getByUserName(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
    }

    @PostMapping("/createWithList")
    public ResponseEntity<?> createList(@RequestBody List<User> userList) {
        for (User user : userList) {
            if (userService.create(user)) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/createWithArray")
    public ResponseEntity<?> createArray(@RequestBody User[] userArray) {
        for (User user : userArray) {
            if (userService.create(user)) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
