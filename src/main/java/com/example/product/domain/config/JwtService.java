package com.example.product.domain.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    public TokenInfo parseToken(String token){
        Claims body = (Claims) Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parse(token)
                .getBody();
        return TokenInfo.builder()
                .id(UUID.fromString(body.get("id", String.class)))
                .userId(body.get("userId", String.class))
                .name(body.get("name", String.class))
                .phoneNumber(body.get("phoneNumber", String.class))
                .email(body.get("email", String.class))
                .birth(LocalDate.parse(body.get("birth", String.class)))
                .role(body.get("role", String.class))
                .build();
    }


}
