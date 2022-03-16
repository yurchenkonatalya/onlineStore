package by.bsuir.rest;

import by.bsuir.entity.dto.*;
import by.bsuir.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static by.bsuir.constant.ApiPath.*;

@RestController
@Slf4j
public class UserRest {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserRest(UserService userService,
                    AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(USER_LOGIN)
    public JwtDto login(@RequestBody AuthDto authDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword()));
        return userService.login(authDto);
    }

    @PostMapping(USER_LOGIN_GOOGLE)
    public JwtDto loginByGoogle(@RequestBody GoogleDto googleDto) throws IOException {
        return userService.loginByGoogle(googleDto);
    }

    @GetMapping(USER_LOGOUT)
    public void logout(@RequestHeader(name = AUTHORIZATION) String token) {
        userService.logout(token);
    }

    @GetMapping(USER_AUTH)
    public JwtDto auth(@RequestHeader(name = AUTHORIZATION) String token) {
        return userService.auth(token);
    }

    @PostMapping(USER_REGISTRATION)
    public RegResultDto registration(@RequestBody RegDto regDto) {
        return userService.registration(regDto);
    }

    @GetMapping(EMAIL_ACTIVATION)
    public void activation(@PathVariable String key) {
        userService.activateEmail(key);
    }
}
