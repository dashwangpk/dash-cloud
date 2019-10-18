package com.sprint.dash.entities.system.dto;

import com.sprint.dash.entities.system.SysUserEntity;
import lombok.Data;

import java.util.Map;

@Data
public class SysUserDTO extends SysUserEntity {

    private Map<String, Object> params;

}
