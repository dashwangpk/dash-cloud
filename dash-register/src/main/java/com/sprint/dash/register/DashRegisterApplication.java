package com.sprint.dash.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DashRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashRegisterApplication.class, args);
    }

}
