package com.sprint.dash.server.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:dash-server-system.properties"})
@ConfigurationProperties(prefix = "dash.server.system")
public class DashServerSystemProperties {

    private DashSwaggerProperties swagger = new DashSwaggerProperties();

}
