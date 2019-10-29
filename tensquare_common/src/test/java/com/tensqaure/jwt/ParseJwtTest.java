package com.tensqaure.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwtTest {

    public static void main(String[] args) {
        Claims itcast = Jwts
                .parser()
                .setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NzIyNjE1NTksImV4cCI6MTU3MjI2MTYxOSwicm9sZSI6ImFkbWluIn0.d0oTgNP0Orpc_on3bOJykhHjOKue3KHnSve-dC3A_Mc")
                .getBody();

        System.out.println("用户id：" + itcast.getId());
        System.out.println("用户名：：" + itcast.getSubject());
        System.out.println("登陆时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(itcast.getIssuedAt()));
        System.out.println("过期时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(itcast.getExpiration()));
        System.out.println("用户角色：" + itcast.get("role"));
    }
}
