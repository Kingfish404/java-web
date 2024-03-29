package com.achacker.config;

import com.achacker.pojo.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.achacker.pojo")
public class Config {

    @Bean
    public Client user() {
        return new Client();
    }
}
