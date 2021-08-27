package com.digitalinnovationone.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfig {
    private String driveClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection(){
        System.out.println("DB connection for dev:");
        System.out.println(driveClassName);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        return "DB Connection Instance DEV end";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection(){
        System.out.println("DB connection for prod:");
        System.out.println(driveClassName);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        return "DB Connection Instance PROD end";
    }


}
