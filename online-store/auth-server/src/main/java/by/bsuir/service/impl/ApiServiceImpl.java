package by.bsuir.service.impl;

import by.bsuir.util.JsonParser;
import by.bsuir.entity.dto.api.UserGoogleResponse;
import by.bsuir.exception.GoogleRequestException;
import by.bsuir.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Objects;

@Service
@Slf4j
public class ApiServiceImpl implements ApiService {

    private OkHttpClient  client;

    @Value("${api.google.checkToken}")
    private String googleApiUri;

    @PostConstruct
    public void init(){
        client = new OkHttpClient();
    }

    @Override
    public UserGoogleResponse checkGoogleAccessToken(String accessToken){
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(googleApiUri).newBuilder();

        urlBuilder.addQueryParameter("access_token", accessToken);

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return JsonParser.simpleParser(Objects.requireNonNull(response.body()).string(), UserGoogleResponse.class);
        }catch (IOException e){
            log.error("Failed request to Google");
        }
        throw new GoogleRequestException(HttpStatus.BAD_REQUEST);
    }
}
