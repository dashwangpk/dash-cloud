package com.sprint.dash.server.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sprint.dash.entities.system.SysUserEntity;
import com.sprint.dash.entities.system.dto.SysUserDTO;
import com.sprint.dash.entities.system.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    List<SysUserVO> userList();

    IPage<SysUserVO> userPage(IPage<SysUserVO> page, @Param("sysUserDTO") SysUserDTO sysUserDTO);
}
