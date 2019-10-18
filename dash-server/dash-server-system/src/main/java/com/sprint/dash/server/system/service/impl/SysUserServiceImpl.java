package com.sprint.dash.server.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sprint.dash.entities.system.SysUserEntity;
import com.sprint.dash.entities.system.dto.SysUserDTO;
import com.sprint.dash.entities.system.vo.SysUserVO;
import com.sprint.dash.entities.utils.PageUtils;
import com.sprint.dash.entities.utils.Query;
import com.sprint.dash.server.system.mapper.SysUserMapper;
import com.sprint.dash.server.system.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Override
    public List<SysUserVO> userList() {
        List<SysUserVO> userList = this.baseMapper.userList();
        return userList;
    }

    @Override
    public PageUtils userPage(SysUserDTO sysUserDTO) {
        IPage<SysUserVO> paramsPage = new Query<SysUserVO>().getPage(sysUserDTO.getParams());
        IPage<SysUserVO> page = this.baseMapper.userPage(paramsPage, sysUserDTO);
        return new PageUtils(page);
    }

}
