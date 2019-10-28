package com.sprint.dash.auth.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.sprint.dash.auth.properties.DashAuthProperties;
import com.sprint.dash.common.utils.MD5Util;
import com.sprint.dash.entities.auth.AuthInfo;
import com.sprint.dash.entities.system.dto.SysUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtUtil {

    private static DashAuthProperties DASH_AUTH_PROPERTIES;

    @Autowired
    private DashAuthProperties dashAuthProperties;

    @PostConstruct
    public void getAuthProperties(){
        DASH_AUTH_PROPERTIES = dashAuthProperties;
    }

    public static AuthInfo generateToken(SysUserDTO sysUser){

        AuthInfo authInfo = new AuthInfo();
        Date now = new Date();
        Algorithm algorithm = Algorithm.HMAC256(DASH_AUTH_PROPERTIES.getSecretKey()); //算法

        String accessToken = JWT.create()
                .withIssuer(DASH_AUTH_PROPERTIES.getIssuer()) //签发人
                .withIssuedAt(now) //签发时间
                .withExpiresAt(new Date(now.getTime() + DASH_AUTH_PROPERTIES.getTokenExpireTime())) //过期时间
                .withClaim("userId", sysUser.getUserId()) //保存身份标识
                .withClaim("name", sysUser.getName()) //保存身份标识
                .withClaim("username", sysUser.getUsername()) //保存身份标识
                .sign(algorithm);

        String refreshToken = generateRefreshToken(sysUser);
        authInfo.setAccessToken(accessToken);
        authInfo.setRefreshToken(refreshToken);
        return authInfo;
    }

    public static boolean verifyToken(AuthInfo authInfo) {
        return verifyToken(authInfo.getAccessToken());
    }

    public static Map<String, Object> verifyAccessToken(String accessToken) {

        Map<String, Object> verifyResult = new HashMap<String, Object>();
        verifyResult.put("result", true);
        verifyResult.put("msg", "验证成功！");
        try{
            Algorithm algorithm = Algorithm.HMAC256(DASH_AUTH_PROPERTIES.getSecretKey());
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(DASH_AUTH_PROPERTIES.getIssuer())
                    .build();
            verifier.verify(accessToken);

            return verifyResult;
        }catch (Exception e){
            log.error("Jwt token 验证错误 :" + e.getMessage(), e);
            verifyResult.put("result", false);
            verifyResult.put("msg", "401 unauthorized! Jwt token 验证错误 :" + e.getMessage());
        }
        return verifyResult;
    }

    public static boolean verifyToken(String accessToken){
        try{
            Algorithm algorithm = Algorithm.HMAC256(DASH_AUTH_PROPERTIES.getSecretKey());
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(DASH_AUTH_PROPERTIES.getIssuer())
                    .build();
            verifier.verify(accessToken);
            return true;
        }catch (Exception e){
            log.error("Jwt token 验证错误 :" + e.getMessage(), e);
        }
        return false;
    }

    public static SysUserDTO getSysUser(AuthInfo authInfo){
        return getSysUser(authInfo.getAccessToken());
    }

    public static SysUserDTO getSysUser(String accessToken){
        Algorithm algorithm = Algorithm.HMAC256(DASH_AUTH_PROPERTIES.getSecretKey());
        Long userId = JWT.decode(accessToken).getClaim("userId").asLong();
        String name = JWT.decode(accessToken).getClaim("name").asString();
        String username = JWT.decode(accessToken).getClaim("username").asString();

        SysUserDTO sysUser = new SysUserDTO();
        sysUser.setName(name);
        sysUser.setUsername(username);
        sysUser.setUserId(userId);
        return sysUser;
    }

    public static String generateRefreshToken(SysUserDTO sysUser) {
        return generateRefreshToken(sysUser.getUserId());
    }

    public static String generateRefreshToken(Long userId) {
        String refreshToken = new MD5Util().encode(DASH_AUTH_PROPERTIES.getSecretKey()
                + userId + System.currentTimeMillis());
        return refreshToken;
    }

}
