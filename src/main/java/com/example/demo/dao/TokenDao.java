package com.example.demo.dao;

import com.example.demo.model.Token;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface TokenDao {
    void add(Token token);
    void delete(Token token);
    Optional<Token> getById(String tokenId);
    boolean contains(String tokenId);
}
