package com.sprint.dash.server.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.sprint.dash.server.system.mapper")
@ComponentScan(basePackages = {"com.sprint.dash"})
@EnableFeignClients(basePackages = {"com.sprint.dash.api"})
public class DashServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashServerSystemApplication.class, args);
    }

}
