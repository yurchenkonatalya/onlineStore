package by.bsuir.service;

import by.bsuir.entity.dto.AuthDto;
import by.bsuir.entity.dto.GoogleDto;
import by.bsuir.entity.dto.JwtDto;
import by.bsuir.entity.dto.RegDto;

import java.io.IOException;

public interface UserService {
    JwtDto login(AuthDto authDto);
    JwtDto loginByGoogle(GoogleDto authDto) throws IOException;
    JwtDto auth(String token);
    void logout(String token);
    void registration(RegDto regDto);
    void activateEmail(String key);
}
