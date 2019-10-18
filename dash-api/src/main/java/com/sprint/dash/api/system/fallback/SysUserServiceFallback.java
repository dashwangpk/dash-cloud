package com.sprint.dash.api.system.fallback;

import com.sprint.dash.api.system.ISysUserService;
import com.sprint.dash.common.utils.R;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SysUserServiceFallback implements FallbackFactory<ISysUserService> {

    @Override
    public ISysUserService create(Throwable throwable) {
        return new ISysUserService(){
            @Override
            public R userList() {
                log.error("调用dash-server-system服务出错", throwable);
                return R.error("调用dash-server-system服务出错");
            }
        };
    }
}
