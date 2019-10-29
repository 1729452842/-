package com.tensqaure.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreateJwt {

    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"itcast")
                .setId("666")
                .setSubject("小马")
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 60000))
                .claim("role","admin");
        System.out.println(jwtBuilder.compact());
    }
}
