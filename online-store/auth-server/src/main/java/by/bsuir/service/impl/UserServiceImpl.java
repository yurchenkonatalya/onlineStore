package by.bsuir.service.impl;

import by.bsuir.dao.RefDao;
import by.bsuir.dao.TokenDao;
import by.bsuir.dao.UserDao;
import by.bsuir.entity.domain.Token;
import by.bsuir.entity.domain.User;
import by.bsuir.entity.dto.AuthDto;
import by.bsuir.entity.dto.JwtDto;
import by.bsuir.entity.dto.RegDto;
import by.bsuir.exception.*;
import by.bsuir.service.AuthService;
import by.bsuir.service.UserService;
import by.bsuir.service.mail.ActivationMail;
import by.bsuir.service.mail.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final AuthService authService;
    private final EmailService emailService;
    private final CryptoServiceImpl cryptoService;
    private final UserDao userDao;
    private final RefDao refDao;
    private final TokenDao tokenDao;
    private final Map<String, String> nonActiveEmails;

    @Autowired
    public UserServiceImpl(AuthService authService, EmailService emailService, CryptoServiceImpl cryptoService,
                           UserDao userDao, RefDao refDao, TokenDao tokenDao){
        this.authService = authService;
        this.emailService = emailService;
        this.cryptoService = cryptoService;
        this.userDao = userDao;
        this.refDao = refDao;
        this.tokenDao = tokenDao;
        nonActiveEmails = new HashMap<>();
    }

    @Override
    public JwtDto login(AuthDto authDto) {
        User user = userDao.findByEmail(authDto.getEmail()).orElseThrow(() -> new UserIsNotRegisteredException(HttpStatus.UNAUTHORIZED));
        return JwtDto.builder()
                .jwt(authService.generateJwt(user))
                .build();
    }

    @Override
    public JwtDto auth(String token) {
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

    @Transactional
    @Override
    public void registration(RegDto regDto) {
        userDao.findByEmail(regDto.getEmail()).ifPresent((user) -> {
            throw new SuchEmailAlsoRegistredException(HttpStatus.CONFLICT);
        });

        if(!regDto.getPassword().equals(regDto.getRepeatPassword())){
            throw new RepeatPasswordIsNotSameException(HttpStatus.FORBIDDEN);
        }

        User defaultUser = createNonActiveUser(regDto);
        Optional<User> user = userDao.save(defaultUser);
        if(user.isPresent()){
            String key = cryptoService.createActivationKey(user.get().getUserEmail());
            nonActiveEmails.put(key, user.get().getUserEmail());
            emailService.sendHtml(new ActivationMail(user.get().getUserEmail(), key));
        }
    }

    @Override
    public void activateEmail(String key) {
        if(!nonActiveEmails.containsKey(key) || !nonActiveEmails.get(key).equals(cryptoService.getEmailFromActivationKey(key))){
            throw new ActivationKeyIsNotExist(HttpStatus.FORBIDDEN);
        }
        String email = nonActiveEmails.remove(key);
        Optional<User> user = userDao.findByEmail(email);
        user.ifPresent(value -> {
            value.setUserStatus(refDao.findActiveUserStatus());
            userDao.save(value);
        });
    }

    private User createNonActiveUser(RegDto regDto){
        return User.builder()
                .userEmail(regDto.getEmail())
                .userHashPass(cryptoService.encodePassword(regDto.getPassword()))
                .actualDate(LocalDateTime.now())
                .userPhone(regDto.getPhoneNumber())
                .userStatus(refDao.findNonActiveUserStatus())
                .userRole(refDao.findUserRole())
                .build();
    }
}
