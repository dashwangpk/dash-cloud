package com.sprint.dash.auth.service;

import com.sprint.dash.common.utils.R;
import com.sprint.dash.entities.auth.AuthInfo;
import com.sprint.dash.entities.system.dto.SysUserDTO;

public interface AuthService {

    R login(SysUserDTO sysUser);

    R refreshToken(AuthInfo authInfo);
}
