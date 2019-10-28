package com.sprint.dash.auth.service.impl;

import com.sprint.dash.auth.properties.DashAuthProperties;
import com.sprint.dash.auth.service.AuthService;
import com.sprint.dash.auth.utils.JwtUtil;
import com.sprint.dash.common.constant.CommonConstant;
import com.sprint.dash.common.utils.R;
import com.sprint.dash.common.utils.RedisUtils;
import com.sprint.dash.entities.auth.AuthInfo;
import com.sprint.dash.entities.system.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private DashAuthProperties dashAuthProperties;

    @Override
    public R login(SysUserDTO sysUser) {
        sysUser.getUsername();
        sysUser.getPassword();
        sysUser.setUserId(1222l);
        sysUser.setName("asas");
        sysUser.setPassword(null);

        AuthInfo authInfo = JwtUtil.generateToken(sysUser);
        redisUtils.putHash(authInfo.getRefreshToken(),
                CommonConstant.Auth.ACCESS_TOKEN_NAME, authInfo.getAccessToken(),
                dashAuthProperties.getRefreshTokenExpireTime());
        redisUtils.putHash(authInfo.getRefreshToken(),
                CommonConstant.Auth.USER_INFO, sysUser,
                dashAuthProperties.getRefreshTokenExpireTime());

        return R.ok().put("authInfo", authInfo);
    }

    @Override
    public R refreshToken(AuthInfo authInfo) {

        SysUserDTO sysUser = redisUtils.getHash(authInfo.getRefreshToken(),
                CommonConstant.Auth.USER_INFO, SysUserDTO.class);
        if(sysUser == null){
            return R.error(1003, "refreshToken error");
        }

        AuthInfo newAuthInfo = JwtUtil.generateToken(sysUser);
        newAuthInfo.setRefreshToken(authInfo.getRefreshToken());

        redisUtils.putHash(authInfo.getRefreshToken(),
                CommonConstant.Auth.ACCESS_TOKEN_NAME, newAuthInfo.getAccessToken(),
                dashAuthProperties.getRefreshTokenExpireTime());

        return R.ok().put("newAuthInfo", newAuthInfo);
    }

}
