package by.bsuir.dao.impl;

import by.bsuir.dao.TokenDao;
import by.bsuir.entity.domain.Token;
import by.bsuir.repo.TokenRepo;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class TokenDaoImpl implements TokenDao {

    private final TokenRepo tokenRepo;

    public TokenDaoImpl(TokenRepo tokenRepo){
        this.tokenRepo = tokenRepo;
    }

    @Override
    public Optional<Token> findByToken(String token) {
        return tokenRepo.findByToken(token);
    }

    @Override
    public Token addTokenToBlackList(Token token) {
        return tokenRepo.save(token);
    }

    @Override
    public void removeExpirationTokens() {
        tokenRepo.deleteByEndDateBefore(new Date());
    }
}
