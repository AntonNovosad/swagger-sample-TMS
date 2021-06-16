package com.example.demo.service;

import com.example.demo.dao.TokenDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenService {
    @Autowired
    TokenDao tokenDao;
    @Autowired
    UserDao userDao;

    public Token generate(String username) {
        int userId = (userDao.getByUserName(username).get().getId());
        String tokenId = UUID.randomUUID().toString();
        Token token = new Token(userId, tokenId);
        tokenDao.add(token);
        return token;
    }

    public boolean delete(String tokenId) {
        if (tokenDao.contains(tokenId)) {
            tokenDao.delete(tokenDao.getById(tokenId).get());
            return true;
        }
        return false;
    }
}
