package by.bsuir.service;

import by.bsuir.entity.domain.User;
import org.springframework.security.core.Authentication;

import java.util.Date;

public interface AuthService {
    String generateJwt(User user);
    boolean isValidToken(String token);
    Integer getUserIdByToken(String token);
    Date getExpirationTimeByToken(String token);
    Authentication getAuthentication(String token);
}
