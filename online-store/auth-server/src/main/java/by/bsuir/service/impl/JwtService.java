package by.bsuir.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
@Slf4j
public class JwtService {
    @Value("${jwt.secret}")
    private String key;

    private Key secretKey;

    @PostConstruct
    public void init(){
        secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(Integer id, Map<String, String> claims, Long expiration){
        Date start = new Date();
        Date end = new Date(start.getTime() + expiration * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(id))
                .setIssuedAt(start)
                .setExpiration(end)
                .signWith(secretKey)
                .compact();
    }

    public String getUserId(String token){
        return getBody(token).getSubject();
    }

    public Date getExpirationDate(String token){
        return getBody(token).getExpiration();
    }

    public boolean isValidTokenByExpiration(String token){
        Date currentDate = new Date();
        Date expirationDate = getExpirationDate(token);
        return currentDate.before(expirationDate);
    }

    private Claims getBody(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build().parseClaimsJws(token)
                .getBody();
    }
}
