package com.example.demo.dao.inMemory;

import com.example.demo.dao.TokenDao;
import com.example.demo.model.Token;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryTokenDao implements TokenDao {
    private List<Token> tokenList = new ArrayList<>();

    @Override
    public void add(Token token) {
        tokenList.add(token);
    }

    @Override
    public void delete(Token token) {
        tokenList.remove(token);
    }

    @Override
    public Optional<Token> getById(String tokenId) {
        for (Token token : tokenList) {
            if (token.getTokenId().equals(tokenId)) {
                return Optional.of(token);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean contains(String tokenId) {
        for (Token token : tokenList) {
            if (token.getTokenId().equals(tokenId)) {
                return true;
            }
        }
        return false;
    }
}
