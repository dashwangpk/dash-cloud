package com.sprint.dash.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.sprint.dash.server.auth.mapper")
@ComponentScan(basePackages = {"com.sprint.dash"})
public class DashAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashAuthApplication.class, args);
    }

}
