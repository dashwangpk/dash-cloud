package com.sprint.dash.entities.system.vo;

import com.sprint.dash.entities.system.SysUserEntity;
import lombok.Data;

import java.util.Map;

@Data
public class SysUserVO extends SysUserEntity {

    private Map<String, Object> params;

}
