package com.example.equipesecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableConfigurationProperties
public class EquipeSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipeSecurityApplication.class, args);
    }

}
