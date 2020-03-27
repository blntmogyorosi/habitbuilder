package com.bgm.habitbuilder.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class Init {

    @Bean
    @Order(1)
    public CommandLineRunner init() {
        return args -> {};
    }

}