package com.sprint.dash.entities.system.dto;

import com.sprint.dash.entities.system.SysMenuEntity;
import lombok.Data;

import java.util.Map;

@Data
public class SysMenuDTO extends SysMenuEntity {

    private Map<String, Object> params;

}
