package by.bsuir.dao;

import by.bsuir.entity.domain.Token;

import java.util.Optional;

public interface TokenDao {
    Optional<Token> findByToken(String token);
    Token addTokenToBlackList(Token token);
    void removeExpirationTokens();
}
