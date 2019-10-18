package com.sprint.dash.server.system.controller;

import com.sprint.dash.common.utils.R;
import com.sprint.dash.entities.system.dto.SysUserDTO;
import com.sprint.dash.entities.system.vo.SysUserVO;
import com.sprint.dash.entities.utils.PageUtils;
import com.sprint.dash.server.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/list")
    public R userList(){
        log.info("dash-server-system的/sys/user/list服务");
        List<SysUserVO> userList = sysUserService.userList();
        return R.ok().put("userList", userList);
    }

    @RequestMapping("/page")
    public R userPage(@RequestBody SysUserDTO sysUserDTO){
        log.info("dash-server-system的/sys/user/page服务");
        PageUtils page = sysUserService.userPage(sysUserDTO);
        return R.ok().put("page", page);
    }

}
