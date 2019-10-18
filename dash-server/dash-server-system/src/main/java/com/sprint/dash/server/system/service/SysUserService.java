package com.sprint.dash.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sprint.dash.entities.system.SysUserEntity;
import com.sprint.dash.entities.system.dto.SysUserDTO;
import com.sprint.dash.entities.system.vo.SysUserVO;
import com.sprint.dash.entities.utils.PageUtils;

import java.util.List;

public interface SysUserService extends IService<SysUserEntity> {

    List<SysUserVO> userList();

    PageUtils userPage(SysUserDTO sysUserDTO);
}
