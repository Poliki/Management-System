package com.example.meetingdemo.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;

public class JWTUtil {

    // 过期时间5分钟
    private static final long EXPIRE_TIME = 10*60*1000;

    /**
     * 校验token是否正确
     * @param uName 密钥
     * @param uPassword 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String uName, String uPassword) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(uPassword);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("uName", uName)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("uName").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     * @param uName 用户名
     * @param uPassword 用户的密码
     * @return 加密的token
     */
    public static String sign(String uName, String uPassword) {
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(uPassword);
        // 附带username信息
        return JWT.create()
                .withClaim("uName", uName)
                .withExpiresAt(date)
                .sign(algorithm);
    }
}
