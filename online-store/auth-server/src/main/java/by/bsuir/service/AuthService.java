package by.bsuir.service;

import by.bsuir.entity.domain.User;

import java.util.Date;

public interface AuthService {
    String generateJwt(User user);
    boolean checkPassword(String userPass, String databasePass);
    boolean isValidToken(String token);
    Integer getUserIdByToken(String token);
    Date getExpirationTimeByToken(String token);
}
