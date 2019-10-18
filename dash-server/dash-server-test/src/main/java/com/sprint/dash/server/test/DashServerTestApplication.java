package com.sprint.dash.server.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.sprint.dash.server.test.mapper")
@ComponentScan(basePackages = {"com.sprint.dash"})
@EnableFeignClients(basePackages = {"com.sprint.dash.api"})
public class DashServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashServerTestApplication.class, args);
    }

}
