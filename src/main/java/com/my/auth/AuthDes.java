package com.my.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "site.auth")
public class AuthDes {

    private String firstName;

    private String lastName;

}
