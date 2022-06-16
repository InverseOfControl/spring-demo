package com.ghx.springboot.springbootsecurity.security.utils;

import com.ghx.springboot.springbootsecurity.entity.User;
import com.ghx.springboot.springbootsecurity.security.userdeatil.JWTUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * JWT Token 工具类
 */
public class JWTTokenUtil {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 密钥，不同用户取不同的密钥
     */
    private static final String SECRET = "wwjg@123.com";
    private static final String ISS = "kfit";

    /**
     * 过期时间 1 个小时
     */
    private static final long EXPIRATION = 3600L;

    /**
     * 选择记住我之后的过期时间为 7 天
     */
    private static final long EXPIRATION_REMEMBER = 604800L;

    /**
     * 创建 Token
     *
     * @param jwtUser      用户信息
     * @param isRememberMe 是否勾选了记住我
     * @return 返回 Token 字符串
     */
    public static String createToken(JWTUser jwtUser, boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;

        Map<String, Object> map = new HashMap<>(8);
        map.put("id", jwtUser.getUser().getId());
        map.put("role", jwtUser.getAuthoritiesStr());

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(map)
                .setIssuer(ISS)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    /**
     * 是否已过期
     */
    public static boolean isExpiration(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }

    /**
     * 解析 Token 为 Claims 对象
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 解析 Token 为 JWTUser 对象.
     */
    public static JWTUser parseTokenToJwtUser(String token) {
        Claims claims = parseToken(token);
        JWTUser jwtUser = new JWTUser();

        User user = new User();
        user.setId(Long.valueOf(claims.getOrDefault("id", 0L).toString()));

        String role = Objects.toString(claims.get("role"), "");
        jwtUser.setAuthoritiesStr(role);
        jwtUser.setUser(user);
        return jwtUser;
    }
}