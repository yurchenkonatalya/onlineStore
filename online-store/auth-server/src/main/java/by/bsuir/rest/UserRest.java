package by.bsuir.rest;

import by.bsuir.entity.dto.JwtDto;
import by.bsuir.entity.dto.AuthDto;
import by.bsuir.exception.TokenIsNotValid;
import by.bsuir.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static by.bsuir.constant.ApiPath.*;

@RestController
@Slf4j
public class UserRest {

    private final UserService userService;

    @Autowired
    public UserRest(UserService userService){
        this.userService = userService;
    }

    @PostMapping(USER_LOGIN)
    public JwtDto login(@RequestBody AuthDto authDto){
        return userService.login(authDto);
    }

    @GetMapping(USER_LOGOUT)
    public void logout(@RequestHeader(name = AUTHORIZATION, required = false) String token){
        if(token == null){
            throw new TokenIsNotValid(HttpStatus.BAD_REQUEST);
        }
        userService.logout(token);
    }

    @GetMapping(USER_AUTH)
    public JwtDto auth(@RequestHeader(name = AUTHORIZATION, required = false) String token){
        return userService.auth(token);
    }
}
