package by.bsuir.service.impl;

import by.bsuir.dao.TokenDao;
import by.bsuir.entity.domain.Token;
import by.bsuir.entity.domain.User;
import by.bsuir.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenDao tokenDao;

    @Value("${jwt.expiration}")
    private String expiration;

    @Autowired
    public AuthServiceImpl(JwtService jwtService, BCryptPasswordEncoder bCryptPasswordEncoder,
                           TokenDao tokenDao){
        this.jwtService = jwtService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenDao = tokenDao;
    }

    @Override
    public String generateJwt(User user) {
        Map<String, String> claims = new HashMap<>();
        claims.put("role", user.getUserRole().getRoleName());
        claims.put("email", user.getUserEmail());
        return jwtService.generateToken(user.getUserId(), claims, Long.parseLong(expiration));
    }

    @Override
    public boolean checkPassword(String userPass, String databasePass) {
        return bCryptPasswordEncoder.matches(userPass, databasePass);
    }

    @Override
    public boolean isValidToken(String token) {
        Optional<Token> jwt = tokenDao.findByToken(token);
        if(jwt.isPresent()){
            return false;
        }
        return jwtService.isValidTokenByExpiration(token);
    }

    @Override
    public Integer getUserIdByToken(String token) {
        return Integer.parseInt(jwtService.getUserId(token));
    }

    @Override
    public Date getExpirationTimeByToken(String token) {
        return jwtService.getExpirationDate(token);
    }
}
