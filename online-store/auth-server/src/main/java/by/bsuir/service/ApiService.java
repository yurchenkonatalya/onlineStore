package by.bsuir.service;

import by.bsuir.entity.dto.api.UserGoogleResponse;
import okhttp3.Response;

import java.io.IOException;

public interface ApiService {
    UserGoogleResponse checkGoogleAccessToken(String accessToken);
}
