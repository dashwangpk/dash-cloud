package com.sprint.dash.api.system;

import com.sprint.dash.api.common.DashServerConstant;
import com.sprint.dash.api.system.fallback.SysUserServiceFallback;
import com.sprint.dash.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = DashServerConstant.DASH_SERVER_SYSTEM, contextId = "sysUserServiceClient", fallbackFactory = SysUserServiceFallback.class)
public interface ISysUserService {

    @GetMapping("/sys/user/list")
    R userList();


}
