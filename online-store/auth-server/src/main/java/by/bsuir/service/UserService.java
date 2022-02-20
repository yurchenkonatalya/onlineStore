package by.bsuir.service;

import by.bsuir.entity.dto.AuthDto;
import by.bsuir.entity.dto.JwtDto;
import by.bsuir.entity.dto.RegDto;

public interface UserService {
    JwtDto login(AuthDto authDto);
    JwtDto auth(String token);
    void logout(String token);
    void registration(RegDto regDto);
    void activateEmail(String key);
}
