package com.sprint.dash.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class DashMonitorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashMonitorAdminApplication.class, args);
    }

}
