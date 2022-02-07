package by.bsuir.service.impl;

import by.bsuir.dao.RefDao;
import by.bsuir.dao.TokenDao;
import by.bsuir.dao.UserDao;
import by.bsuir.entity.domain.Token;
import by.bsuir.entity.domain.User;
import by.bsuir.entity.dto.AuthDto;
import by.bsuir.entity.dto.JwtDto;
import by.bsuir.exception.*;
import by.bsuir.service.AuthService;
import by.bsuir.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final AuthService authService;
    private final UserDao userDao;
    private final RefDao refDao;
    private final TokenDao tokenDao;

    @Autowired
    public UserServiceImpl(AuthService authService, UserDao userDao, RefDao refDao, TokenDao tokenDao){
        this.authService = authService;
        this.userDao = userDao;
        this.refDao = refDao;
        this.tokenDao = tokenDao;
    }

    @Override
    public JwtDto login(AuthDto authDto) {
        User user = userDao.findByEmail(authDto.getEmail()).orElseThrow(() -> new UserIsNotRegisteredException(HttpStatus.UNAUTHORIZED));
        if(!authService.checkPassword(authDto.getPassword(), user.getUserHashPass())){
            throw new IncorrectPasswordException(HttpStatus.UNAUTHORIZED);
        }

        if(user.getUserStatus().equals(refDao.findNonActiveUserStatus())){
            throw new NonActiveAccountException(HttpStatus.FORBIDDEN);
        }

        if(user.getUserStatus().equals(refDao.findBannedUserStatus())){
            throw new AccountIsBannedException(HttpStatus.FORBIDDEN);
        }

        return JwtDto.builder()
                .jwt(authService.generateJwt(user))
                .build();
    }

    @Override
    public JwtDto auth(String token) {
        if(!authService.isValidToken(token)){
            throw new TokenIsNotValid(HttpStatus.FORBIDDEN);
        }
        Optional<User> user = userDao.findById(authService.getUserIdByToken(token));
        return JwtDto.builder()
                .jwt(authService.generateJwt(user.get()))
                .build();
    }

    @Override
    public void logout(String token) {
        Optional<User> user = userDao.findById(authService.getUserIdByToken(token));
        user.ifPresent(value -> tokenDao.addTokenToBlackList(Token.builder()
                .token(token)
                .endDate(authService.getExpirationTimeByToken(token))
                .user(value).build()));
    }
}
