package com.YJ.PMS.config.AppConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;

public class JwtProvider {

    static SecretKey key= Keys.hmacShaKeyFor(JwtConstant.SECRETE_KEY.getBytes());
//    Claims claims = Jwts.parser().verifyWith(key)
//            .build()
//            .parseSignedClaims(jwt)
//            .getPayload();;
//
//    String email=String.valueOf(claims.get("email"));
//    String authorities=String.valueOf(claims.get("authorities"));

    public static String generateToken(Authentication auth){
//        Collection<? extends GrantedAuthority> authorities=auth.getAuthorities();
        return Jwts.builder().issuedAt(new Date())
                .expiration(new Date(new Date().getTime()+86400000))
                .claim("email",auth.getName())
                .signWith(key)
                .compact();

    }

    public static String getEmailFromToken(String jwt){
            Claims claims = Jwts.parser().verifyWith(key)
            .build()
            .parseSignedClaims(jwt)
            .getPayload();;

    String email=String.valueOf(claims.get("email"));
    return String.valueOf(claims.get("email"));

    }
}
