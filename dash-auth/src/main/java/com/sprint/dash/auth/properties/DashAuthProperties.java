package com.sprint.dash.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:dash-auth.properties"})
@ConfigurationProperties(prefix = "dash.auth")
public class DashAuthProperties {

    private String secretKey;
    private long tokenExpireTime = 5 * 60 * 1000;
    private long refreshTokenExpireTime = 10 * 60 * 1000;
    private String issuer;

}
