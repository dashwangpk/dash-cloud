package com.sprint.dash.auth.controller;

import com.sprint.dash.auth.service.AuthService;
import com.sprint.dash.common.utils.R;
import com.sprint.dash.entities.auth.AuthInfo;
import com.sprint.dash.entities.system.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping("/login")
    public R login(@RequestBody SysUserDTO sysUser){
        R r = authService.login(sysUser);
        return r;
    }

    @RequestMapping("/refreshToken")
    public R refreshToken(@RequestBody AuthInfo authInfo){
        R r = authService.refreshToken(authInfo);
        return r;
    }


}
