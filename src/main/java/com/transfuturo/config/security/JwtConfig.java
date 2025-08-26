package com.transfuturo.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Configuração do JWT")
@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;
    @Value("${jwt.issuer}")
    private String issuer;

    public String getSecret() {
        return secret;
    }
    public long getExpiration() {
        return expiration;
    }
    public String getIssuer() {
        return issuer;
    }
}
