//package com.bezkoder.springjwt.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.Jwts;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import java.security.Key;
//import java.util.*;
//
//
//@Component
//public class TokenProvider {
//
//    private static final String AUTHORITIES_KEY = "auth";
//
//    private Key key;
//
//
//    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);
//
//
//    @Value("${security.jwt.token.secret-key:secret-key}")
//    private String secretKey;
//
//    @Value("${security.jwt.token.expire-length:3600000}")
//    private long validityInMilliseconds = 3600000;
//
//    @Autowired
//    private MyUserDetails myUserDetails;
//
//    @PostConstruct
//    protected void init() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//
////    public String createToken(String mail, Role role) {
////
////        Claims claims = Jwts.claims().setSubject(mail);
////        claims.put("auth", role.getAuthority());
////        Date now = new Date();
////        Date validity = new Date(now.getTime() + validityInMilliseconds);
////
////        return Jwts.builder()
////                .setClaims(claims)
////                .setIssuedAt(now)
////                .setExpiration(validity)
////                .signWith(SignatureAlgorithm.HS256, secretKey)
////                .compact();
////    }
//
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = myUserDetails.loadUserByUsername(getUsername(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    public String getUsername(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public String resolveToken(HttpServletRequest req) {
//        String bearerToken = req.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            return false;
//        }
//    }
//
//
//}
