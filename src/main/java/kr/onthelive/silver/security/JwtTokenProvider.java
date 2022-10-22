package kr.onthelive.silver.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    private static final Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);
    private static final String JWT_SECRET = "secretKey";

    // 토큰 유효시간
    private static final int JWT_EXPIRATION_MS = 604800000;

    // jwt 토큰 생성

    public static String generateToken(String userId, String role){
        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("roles", role);

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date()) // 현재 시간 기반으로 생성
                .setExpiration(expiryDate) // 만료 시간 세팅
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET) // 사용할 암호화 알고리즘, signature에 들어갈 secret 값 세팅
                //.signWith(key,SignatureAlgorithm.HS512)
                .compact();
    }
    public static String generateToken(Authentication authentication) {

        Claims claims = Jwts.claims().setSubject((String) authentication.getPrincipal());
        claims.put("roles", authentication);

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);
        //Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setClaims(claims)
                //.setSubject((String) authentication.getPrincipal()) // 사용자
                .setIssuedAt(new Date()) // 현재 시간 기반으로 생성
                .setExpiration(expiryDate) // 만료 시간 세팅
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET) // 사용할 암호화 알고리즘, signature에 들어갈 secret 값 세팅
                //.signWith(key,SignatureAlgorithm.HS512)
                .compact();
    }

    // Jwt 토큰에서 아이디 추출
    public static String getUserIdFromJWT(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

//        claims = Jwts.builder()
//                .setSigningKey(JWT_SECRET.getBytes(StandardCharsets.UTF_8))
//                .parseClaimsJws(token)
//                .getBody();

        return claims.getSubject();
    }

    public static String getRoleFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return  (String)claims.get("roles");
    }

    public static Authentication getAuthorities(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return (Authentication) claims.get("roles");
    }

    // Jwt 토큰 유효성 검사
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }


}
