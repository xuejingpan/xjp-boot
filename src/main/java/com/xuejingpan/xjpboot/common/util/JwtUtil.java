package com.xuejingpan.xjpboot.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @ClassName JWTUtil
 * @Description JWT工具类
 * @Author xuejingpan
 */
public class JwtUtil {

    /**
     * 过期时间（单位：毫秒）
     */
    private static final long EXPIRES = 24 * 60 * 60 * 1000;

    /**
     * 声明
     */
    private static final String CLAIM = "claim";

    /**
     * 秘钥
     */
    private static final String SECRET = "jwt-secret";

    /**
     * 创建token
     * @param claim token的声明信息
     * @return token
     */
    public static String createToken(String claim) {
        return createToken(claim, EXPIRES);
    }

    /**
     * 创建token
     * @param claim token的声明信息
     * @param expires token的过期时间
     * @return token
     */
    public static String createToken(String claim, long expires) {
        return JWT.create()
                // token生成时间
                .withIssuedAt(new Date())
                // token过期时间
                .withExpiresAt(new Date(System.currentTimeMillis() + expires))
                // 自定义声明（不建议存放敏感信息）
                .withClaim(CLAIM, claim)
                // 签名
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 验证token，并返回声明信息
     * @param token token
     * @return token声明信息
     * @throws JWTVerificationException JWT验证异常
     * @throws TokenExpiredException token过期异常
     */
    public static String checkToken(String token) throws JWTVerificationException, TokenExpiredException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim(CLAIM).asString();
    }

    /**
     * 获取token的声明信息（过期也可以正常解析）
     * @param token token
     * @return token声明信息
     * @throws JWTDecodeException JWT解析异常
     */
    public static String getClaim(String token) throws JWTDecodeException {
        return JWT.decode(token).getClaim(CLAIM).asString();
    }
}
