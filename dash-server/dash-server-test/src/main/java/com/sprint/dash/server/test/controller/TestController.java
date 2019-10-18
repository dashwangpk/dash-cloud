package com.sprint.dash.server.test.controller;

import com.sprint.dash.api.system.ISysUserService;
import com.sprint.dash.common.utils.R;
import com.sprint.dash.entities.test.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/tapi")
    public R tapi(){

        R r = sysUserService.userList();

        TestEntity testEntity = new TestEntity();
        testEntity.setTestCode("testCode");
        testEntity.setTestName("testName");
        return r;
    }

}
